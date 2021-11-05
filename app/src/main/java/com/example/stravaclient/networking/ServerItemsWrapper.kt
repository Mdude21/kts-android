package com.example.stravaclient.networking

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ServerItemsWrapper<T> (
    val items: List<T>
        )