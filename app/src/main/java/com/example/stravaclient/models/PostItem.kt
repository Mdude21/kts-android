package com.example.stravaclient.models

import java.util.*

data class PostItem (
    val user : String,
    val date : String,
    val post : String,
    var like : Int,
    val comment : Int,
    val uuid: UUID
)