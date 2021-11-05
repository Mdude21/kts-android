package com.example.stravaclient

import android.app.Application
import com.example.stravaclient.database.DataBase
import timber.log.Timber

class StravaApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
        DataBase.init(this)
    }
}