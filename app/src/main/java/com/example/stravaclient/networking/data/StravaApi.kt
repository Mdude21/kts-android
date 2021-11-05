package com.example.stravaclient.networking.data

import com.example.stravaclient.networking.data.models.ActivityItem
import retrofit2.http.GET
import com.example.stravaclient.networking.data.models.AthleteItem

interface StravaApi {

    @GET("athlete")
    suspend fun getLoggedInAthlete(): AthleteItem

    @GET("athlete/activities")
    suspend fun getLoggedInAthleteActivities() : List<ActivityItem>


}