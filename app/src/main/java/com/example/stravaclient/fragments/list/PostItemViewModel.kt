package com.example.stravaclient.fragments.list

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stravaclient.models.CommentItem
import com.example.stravaclient.models.LoadingItem
import com.example.stravaclient.models.PostItem
import java.util.*

class PostItemViewModel : ViewModel(){

    private val _inputListData = MutableLiveData<List<Any>> (
        generateItems()
    )

    private fun generateItems() : List<Any> {
        val defaultItems = List(20){
            when((1..2).random()) {
                1 -> PostItem(
                    user = "Username 1",
                    date = "today",
                    post = "Place to post",
                    like = 0,
                    comment = 0,
                    uuid = UUID.randomUUID()
                )
                2 -> CommentItem(
                    user = "Username 2",
                    date = "yesterday",
                    post = "Place to comment",
                    uuid = UUID.randomUUID()
                )
                else -> error("Wrong random number")
            }
        }
        return defaultItems
    }

    val inputListData : LiveData<List<Any>> = _inputListData

    fun onLikeClick(item: PostItem) {
        item.like++
        _inputListData.value?.let {
            _inputListData.value = it
        }
    }
}
