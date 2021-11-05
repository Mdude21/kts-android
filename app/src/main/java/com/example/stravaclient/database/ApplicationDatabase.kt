package com.example.stravaclient.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.stravaclient.models.Users

@Database(
    entities = [
        Users::class,
    ], version = ApplicationDatabase.DB_VERSION
)
abstract class ApplicationDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "app-database"
    }
}