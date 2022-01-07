package land.sungbin.keyboardbeautify.core

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.WindowInsetsAnimation
import android.widget.LinearLayout
import androidx.core.view.NestedScrollingParent3
import androidx.core.view.NestedScrollingParentHelper
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InsetsAnimationLinearLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), NestedScrollingParent3 {

    private val nestedScrollingParentHelper = NestedScrollingParentHelper(this)
    private var currentNestedScrollingChild: View? = null

    private val imeAnimController = SimpleImeAnimationController()

    private var dropNextY = 0
    private val startViewLocation = IntArray(2)

    var scrollImeOffScreenWhenVisible = true
    var scrollImeOnScreenWhenNotVisible = true

    override fun onStartNestedScroll(child: View, target: View, axes: Int, type: Int): Boolean {
        return (axes and ViewCompat.SCROLL_AXIS_VERTICAL) != 0 && type == ViewCompat.TYPE_TOUCH
    }

    override fun onNestedScrollAccepted(child: View, target: View, axes: Int, type: Int) {
        nestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes, type)
        currentNestedScrollingChild = child
    }

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        if (imeAnimController.isInsetAnimationRequestPending()) {
            consumed[0] = dx
            consumed[1] = dy
            return
        }

        var deltaY = dy
        if (dropNextY != 0) {
            consumed[1] = dropNextY
            deltaY -= dropNextY
            dropNextY = 0
        }

        if (deltaY < 0) {
            if (imeAnimController.isInsetAnimationInProgress()) {
                consumed[1] -= imeAnimController.insetBy(-deltaY)
            } else if (scrollImeOffScreenWhenVisible &&
                !imeAnimController.isInsetAnimationRequestPending() &&
                ViewCompat.getRootWindowInsets(this)
                    ?.isVisible(WindowInsetsCompat.Type.ime()) == true
            ) {
                startControlRequest()
                consumed[1] = deltaY
            }
        }
    }

    override fun onNestedScroll(
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {
        if (dyUnconsumed > 0) {
            if (imeAnimController.isInsetAnimationInProgress()) {
                consumed[1] = -imeAnimController.insetBy(-dyUnconsumed)
            } else if (scrollImeOnScreenWhenNotVisible &&
                !imeAnimController.isInsetAnimationRequestPending() &&
                ViewCompat.getRootWindowInsets(this)
                    ?.isVisible(WindowInsetsCompat.Type.ime()) == false
            ) {
                startControlRequest()
                consumed[1] = dyUnconsumed
            }
        }
    }

    override fun onNestedFling(
        target: View,
        velocityX: Float,
        velocityY: Float,
        consumed: Boolean
    ): Boolean {
        if (imeAnimController.isInsetAnimationInProgress()) {
            imeAnimController.animateToFinish(velocityY)
            return true
        } else {
            val imeVisible = ViewCompat.getRootWindowInsets(this)
                ?.isVisible(WindowInsetsCompat.Type.ime()) == true
            when {
                velocityY > 0 && scrollImeOnScreenWhenNotVisible && !imeVisible -> {
                    imeAnimController.startAndFling(this, velocityY)
                    return true
                }
                velocityY < 0 && scrollImeOffScreenWhenVisible && imeVisible -> {
                    imeAnimController.startAndFling(this, velocityY)
                    return true
                }
            }
        }
        return false
    }

    override fun onStopNestedScroll(target: View, type: Int) {
        nestedScrollingParentHelper.onStopNestedScroll(target, type)

        if (imeAnimController.isInsetAnimationInProgress() &&
            !imeAnimController.isInsetAnimationFinishing()
        ) {
            imeAnimController.animateToFinish()
        }
        reset()
    }

    override fun dispatchWindowInsetsAnimationPrepare(animation: WindowInsetsAnimation) {
        super.dispatchWindowInsetsAnimationPrepare(animation)
        suppressLayoutCompat(false)
    }

    private fun startControlRequest() {
        suppressLayoutCompat(true)
        currentNestedScrollingChild?.getLocationInWindow(startViewLocation)
        imeAnimController.startControlRequest(
            view = this,
            onRequestReady = { onControllerReady() }
        )
    }

    private fun onControllerReady() {
        val scrollingChild = currentNestedScrollingChild
        if (scrollingChild != null) {
            imeAnimController.insetBy(0)
            val location = tempIntArray2
            scrollingChild.getLocationInWindow(location)
            dropNextY = location[1] - startViewLocation[1]
        }
    }

    private fun reset() {
        dropNextY = 0
        startViewLocation.fill(0)
        suppressLayoutCompat(false)
    }

    override fun onNestedScrollAccepted(child: View, target: View, axes: Int) {
        onNestedScrollAccepted(child, target, axes, ViewCompat.TYPE_TOUCH)
    }

    override fun onNestedScroll(
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int
    ) {
        onNestedScroll(
            target,
            dxConsumed,
            dyConsumed,
            dxUnconsumed,
            dyUnconsumed,
            type,
            tempIntArray2
        )
    }

    override fun onStopNestedScroll(target: View) {
        onStopNestedScroll(target, ViewCompat.TYPE_TOUCH)
    }
}

private val tempIntArray2 = IntArray(2)
