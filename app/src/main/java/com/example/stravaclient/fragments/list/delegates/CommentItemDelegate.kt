package com.example.stravaclient.fragments.list.delegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stravaclient.R
import com.example.stravaclient.models.CommentItem
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_comment.view.*

class CommentItemDelegate : AbsListItemAdapterDelegate<Any, Any, CommentItemDelegate.ViewHolder>(){

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is CommentItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_comment, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(
        item: Any,
        viewHolder: ViewHolder,
        payloads: MutableList<Any>
    ) {
        viewHolder.bind(item as CommentItem)
    }

    inner class ViewHolder(
        override val containerView: View
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private var currentItem: CommentItem? = null

        fun bind(item: CommentItem) = with(containerView) {
            currentItem = item
            nameComment.text = item.user
            dateComment.text = item.date
            postComment.text = item.post
        }
    }
}