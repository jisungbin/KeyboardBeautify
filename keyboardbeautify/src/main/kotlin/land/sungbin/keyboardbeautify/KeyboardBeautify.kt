package land.sungbin.keyboardbeautify

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsAnimationCompat
import androidx.core.view.WindowInsetsCompat
import land.sungbin.keyboardbeautify.core.ControlFocusInsetsAnimationCallback
import land.sungbin.keyboardbeautify.core.RootViewDeferringInsetsCallback
import land.sungbin.keyboardbeautify.core.TranslateDeferringInsetsAnimationCallback

fun Activity.keyboardBeautify(
    rootView: ViewGroup,
    inputLayout: ViewGroup,
    otherView: View? = null, // optional
    editText: EditText
) {
    val deferringInsetsListener = RootViewDeferringInsetsCallback(
        persistentInsetTypes = WindowInsetsCompat.Type.systemBars(),
        deferredInsetTypes = WindowInsetsCompat.Type.ime()
    )

    /**
     * Set accessable system window
     */
    WindowCompat.setDecorFitsSystemWindows(window, false)

    /**
     * Set [rootView] padding
     */
    ViewCompat.setWindowInsetsAnimationCallback(rootView, deferringInsetsListener)
    ViewCompat.setOnApplyWindowInsetsListener(rootView, deferringInsetsListener)

    /**
     * Set [inputLayout] and [otherView] padding
     */
    ViewCompat.setWindowInsetsAnimationCallback(
        inputLayout,
        TranslateDeferringInsetsAnimationCallback(
            view = inputLayout,
            persistentInsetTypes = WindowInsetsCompat.Type.systemBars(),
            deferredInsetTypes = WindowInsetsCompat.Type.ime(),
            dispatchMode = WindowInsetsAnimationCompat.Callback.DISPATCH_MODE_CONTINUE_ON_SUBTREE
        )
    )
    if (otherView != null) {
        ViewCompat.setWindowInsetsAnimationCallback(
            otherView,
            TranslateDeferringInsetsAnimationCallback(
                view = otherView,
                persistentInsetTypes = WindowInsetsCompat.Type.systemBars(),
                deferredInsetTypes = WindowInsetsCompat.Type.ime()
            )
        )
    }

    /**
     * automatically controll [editText] focus (focused or clear focus)
     */
    ViewCompat.setWindowInsetsAnimationCallback(
        editText,
        ControlFocusInsetsAnimationCallback(editText)
    )
}
