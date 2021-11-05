package com.example.stravaclient.fragments.list

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.stravaclient.fragments.list.delegates.ActivityItemDelegate
import com.example.stravaclient.fragments.list.delegates.PageLoadingAdapterDelegate
import com.example.stravaclient.networking.data.models.ActivityItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class ActivityItemDelegatesAdapter() : AsyncListDifferDelegationAdapter<Any>(
    MainDiffCallback()
){
    init {
        delegatesManager
            .addDelegate(ActivityItemDelegate())
            .addDelegate(PageLoadingAdapterDelegate())

    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(){
        notifyDataSetChanged()
    }

    class MainDiffCallback : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(first: Any, second: Any): Boolean {
            return first.javaClass == second.javaClass && when (first) {
                is ActivityItem -> first.id == (second as ActivityItem).id
                else -> true
            }
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(first: Any, second: Any): Boolean = first == second
    }

}