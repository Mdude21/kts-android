package com.example.stravaclient.networking.data

import com.example.stravaclient.database.DataBase
import com.example.stravaclient.models.Users
import com.example.stravaclient.networking.data.models.ActivityItem
import com.example.stravaclient.networking.data.models.AthleteItem

class UserRepository {

    private val userDao = DataBase.instance.userDao()

    suspend fun saveUser(user: Users) {
        userDao.insertUser(listOf(user))
    }

    suspend fun getAllUsers(): Users {
        return userDao.getAllUsers()
    }

    suspend fun getAthlete() : AthleteItem {
        return Networking.stravaApi.getLoggedInAthlete()
    }

    suspend fun getActivityById() : List<ActivityItem> {
        return Networking.stravaApi.getLoggedInAthleteActivities()
    }
}