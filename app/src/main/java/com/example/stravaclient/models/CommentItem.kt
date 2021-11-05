package com.example.stravaclient.models

import java.util.*

data class CommentItem (
    val user : String,
    val date : String,
    val post : String,
    val uuid : UUID
)