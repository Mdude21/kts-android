package com.example.stravaclient.networking

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteUser (
    @Json(name = "username")
    val username: String,
    @Json(name = "profile")
    val avatar: String?,
    val id: Long
    )