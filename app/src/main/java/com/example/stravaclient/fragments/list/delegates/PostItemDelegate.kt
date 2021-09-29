package com.example.stravaclient.fragments.list.delegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stravaclient.R
import com.example.stravaclient.models.PostItem
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_post.view.*

class PostItemDelegate(private val callback: Callback) : AbsListItemAdapterDelegate<Any, Any, PostItemDelegate.ViewHolder>(){

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is PostItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return ViewHolder(itemView, callback)
    }

    override fun onBindViewHolder(
        item: Any,
        viewHolder: ViewHolder,
        payloads: MutableList<Any>
    ) {
        viewHolder.bind(item as PostItem)
    }

    inner class ViewHolder(
        override val containerView: View, private val callback: Callback
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private var currentItem: PostItem? = null

        fun bind(item: PostItem) = with(containerView) {
            currentItem = item
            postUser.text = item.user
            likeCount.text = item.like.toString()
            commentCount.text = item.comment.toString()
            postDate.text = item.date
            post.text = item.post
            likeButton.setOnClickListener{
                callback.onLikeClick(item)
            }
        }
    }

    interface Callback{
        fun onLikeClick(item: PostItem)
    }
}