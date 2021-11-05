package com.example.stravaclient.networking.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AthleteItem(
    @Json(name = "firstname")
    val firstname: String?,
    @Json(name = "lastname")
    val lastname: String?,
    @Json(name = "profile")
    val avatar: String?,
    @Json(name = "follower_count")
    val countFollowers: Int,
    @Json(name = "friend_count")
    val countFriends: Int,
    @Json(name = "created_at")
    val date: String?,
    val id: Long

)