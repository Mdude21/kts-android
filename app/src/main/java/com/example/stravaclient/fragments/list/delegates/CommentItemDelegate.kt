package com.example.stravaclient.fragments.list.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stravaclient.databinding.ItemCommentBinding
import com.example.stravaclient.models.CommentItem
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate


class CommentItemDelegate() : AbsListItemAdapterDelegate<Any, Any, CommentItemDelegate.ViewHolder>(){

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is CommentItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val binding: ItemCommentBinding = ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        item: Any,
        viewHolder: ViewHolder,
        payloads: MutableList<Any>
    ) {
        viewHolder.bind(item as CommentItem)
    }

    inner class ViewHolder(
        private val binding: ItemCommentBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CommentItem) = with(binding) {
            binding.nameComment.text = item.user
            binding.dateComment.text = item.date
            binding.postComment.text = item.post
        }
    }
}