package com.example.stravaclient

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class OnBoardingViewModel : ViewModel() {

    private val mutableState = MutableLiveData("")
    val state : MutableLiveData<String>
        get() = mutableState

    init {
        Timber.d("OnBoardingViewModel init ${hashCode()}")
    }

    fun addText(text : String) {
        mutableState.value = MutableLiveData(text).toString()
    }

    override fun onCleared() {
        Timber.d("OnboardingViewModel onCleared ${hashCode()}")
        super.onCleared()
    }
}