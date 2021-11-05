package com.example.stravaclient.networking.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.stravaclient.networking.RemoteUser
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class UserAdapter : AsyncListDifferDelegationAdapter<RemoteUser>(
    UserDiffUtilCallback()
) {
    init {
        delegatesManager.addDelegate(UserAdapterDelegate())
    }

    class UserDiffUtilCallback : DiffUtil.ItemCallback<RemoteUser>() {
        override fun areItemsTheSame(oldItem: RemoteUser, newItem: RemoteUser): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RemoteUser, newItem: RemoteUser): Boolean {
            return oldItem == newItem
        }
    }
}