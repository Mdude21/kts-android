package com.example.stravaclient.fragments.list.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stravaclient.R
import com.example.stravaclient.databinding.ItemPostBinding
import com.example.stravaclient.models.PostItem
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class PostItemDelegate(private val callback: Callback) : AbsListItemAdapterDelegate<Any, Any, PostItemDelegate.ViewHolder>(){

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is PostItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        val binding:ItemPostBinding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, callback)
    }

    override fun onBindViewHolder(
        item: Any,
        viewHolder: ViewHolder,
        payloads: MutableList<Any>
    ) {
        viewHolder.bind(item as PostItem)
    }

    inner class ViewHolder(
        private val binding: ItemPostBinding,
        private val callback: Callback
    ) : RecyclerView.ViewHolder(binding.root) {

        private var currentItem: PostItem? = null

        init {
            binding.likeButton.setOnClickListener{
                currentItem?.let { currentItem ->
                    callback.onLikeClick(currentItem)
                }
            }
        }

        fun bind(item: PostItem) = with(binding) {
            currentItem = item
            binding.postUser.text = item.user
            binding.likeCount.text = item.like.toString()
            binding.commentCount.text = item.comment.toString()
            binding.postDate.text = item.date
            binding.post.text = item.post
        }
    }

    interface Callback{
        fun onLikeClick(item: PostItem)
    }
}