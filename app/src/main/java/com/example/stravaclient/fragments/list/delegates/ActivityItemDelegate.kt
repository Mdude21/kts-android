package com.example.stravaclient.fragments.list.delegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stravaclient.R
import com.example.stravaclient.databinding.ItemActivityBinding
import com.example.stravaclient.fragments.athlete.AthleteFragment
import com.example.stravaclient.networking.data.models.ActivityItem
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ActivityItemDelegate : AbsListItemAdapterDelegate<Any, Any, ActivityItemDelegate.ViewHolder>(){

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is ActivityItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_activity, parent, false)
        val binding: ItemActivityBinding = ItemActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, itemView)
    }

    override fun onBindViewHolder(
        item: Any,
        viewHolder: ViewHolder,
        payloads: MutableList<Any>
    ) {
        viewHolder.bind(item as ActivityItem)
    }

    inner class ViewHolder(
        private val binding: ItemActivityBinding,
        private val containerView: View
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ActivityItem) = with(binding) {
            username.text = item.name
            date.text = item.date
            typeActivity.text = item.type
            distanceCount.text = (item.distance / 1000).toString() + " км."
            timeCount.text = (item.moving_time / 60).toString() + " минут"
            likeCount.text = item.kudos_count.toString()
            commentCount.text = item.comment_count.toString()
            Glide.with(containerView)
                .load(AthleteFragment.photo.picture)
                .placeholder(R.drawable.avatar)
                .into(postAvatar)
        }
    }
}