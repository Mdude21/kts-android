package com.example.stravaclient.fragments.list

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.stravaclient.fragments.list.delegates.CommentItemDelegate
import com.example.stravaclient.fragments.list.delegates.PageLoadingAdapterDelegate
import com.example.stravaclient.fragments.list.delegates.PostItemDelegate
import com.example.stravaclient.models.CommentItem
import com.example.stravaclient.models.PostItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MainDelegatesListAdapter(private val callback: PostItemDelegate.Callback) : AsyncListDifferDelegationAdapter<Any>(
    MainDiffCallback()
){
    init {
        delegatesManager
            .addDelegate(PostItemDelegate(callback))
            .addDelegate(CommentItemDelegate())
            .addDelegate(PageLoadingAdapterDelegate())

    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(){
        notifyDataSetChanged()
    }

    class MainDiffCallback : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(first: Any, second: Any): Boolean {
            return first.javaClass == second.javaClass && when (first) {
                is PostItem -> first.uuid == (second as PostItem).uuid
                is CommentItem -> first.uuid == (second as CommentItem).uuid
                else -> true
            }
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(first: Any, second: Any): Boolean = first == second
    }

}