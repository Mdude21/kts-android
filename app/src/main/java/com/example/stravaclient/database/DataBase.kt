package com.example.stravaclient.database

import android.content.Context
import androidx.room.Room

object DataBase {
    lateinit var instance: ApplicationDatabase
        private set

    fun init(context: Context) {
        instance = Room.databaseBuilder(
            context,
            ApplicationDatabase::class.java,
            ApplicationDatabase.DB_NAME
        )
            .build()
    }
}