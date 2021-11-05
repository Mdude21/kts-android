package com.example.stravaclient.networking.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.stravaclient.R
import com.example.stravaclient.databinding.ItemUserBinding
import com.example.stravaclient.networking.RemoteUser
import com.example.stravaclient.networking.utils.bindingInflate
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class UserAdapterDelegate : AbsListItemAdapterDelegate<RemoteUser, RemoteUser, UserAdapterDelegate.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        return Holder(parent.bindingInflate(ItemUserBinding::inflate))
    }

    override fun isForViewType(
        item: RemoteUser,
        items: MutableList<RemoteUser>,
        position: Int
    ): Boolean{
        return true
    }

    override fun onBindViewHolder(
        item: RemoteUser,
        holder: Holder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class Holder(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RemoteUser) {
            binding.usernameTextView.text = item.username

            Glide.with(itemView)
                .load(item.avatar)
                .transform(CircleCrop())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.avatarImageView)
        }
    }
}