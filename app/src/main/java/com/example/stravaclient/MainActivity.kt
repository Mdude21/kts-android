package com.example.stravaclient

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Timber.d("MainActivity onCreate ${hashCode()}")
    }

    override fun onStart() {
        super.onStart()
        Timber.d("MainActivity onStart ${hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("MainActivity onResume ${hashCode()}")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("MainActivity onPause ${hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("MainActivity onStop ${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("MainActivity onDestroy ${hashCode()}")
    }

}
