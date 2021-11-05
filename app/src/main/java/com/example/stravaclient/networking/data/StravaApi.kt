package com.example.stravaclient.networking.data

import retrofit2.http.GET
import com.example.stravaclient.networking.data.models.AthleteItem

interface StravaApi {

    @GET("athlete")
    suspend fun getLoggedAthlete(): AthleteItem

}