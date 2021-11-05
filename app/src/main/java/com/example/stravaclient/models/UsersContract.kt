package com.example.stravaclient.models

object UsersContract {

    const val TABLE_NAME = "users"

    object Columns {
        const val ID = "id"
        const val FIRSTNAME = "firstname"
        const val LASTNAME = "lastname"
        const val PROFILE = "profile"
        const val FOLLOWERS = "follower_count"
        const val FRIENDS = "friend_count"
        const val CREATED = "created_at"
    }
}