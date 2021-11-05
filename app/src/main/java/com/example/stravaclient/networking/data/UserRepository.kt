package com.example.stravaclient.networking.data

import com.example.stravaclient.networking.data.models.AthleteItem

class UserRepository {

    suspend fun getAthlete(
    ) : AthleteItem {
        return Networking.stravaApi.getLoggedAthlete()
    }
}