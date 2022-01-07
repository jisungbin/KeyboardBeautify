package land.sungbin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

internal class ConversationAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = when (viewType) {
            ITEM_TYPE_MESSAGE_SELF -> {
                inflater.inflate(R.layout.message_bubble_self, parent, false)
            }
            else -> {
                inflater.inflate(R.layout.message_bubble_other, parent, false)
            }
        }
        return MessageHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) ITEM_TYPE_MESSAGE_OTHER else ITEM_TYPE_MESSAGE_SELF
    }

    override fun getItemCount(): Int = NUMBER_MESSAGES

    companion object {
        const val ITEM_TYPE_MESSAGE_SELF = 0
        const val ITEM_TYPE_MESSAGE_OTHER = 1
        const val NUMBER_MESSAGES = 50
    }
}

private class MessageHolder(view: View) : RecyclerView.ViewHolder(view)
