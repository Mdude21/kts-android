package com.example.stravaclient.fragments.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stravaclient.networking.data.models.ActivityItem
import com.example.stravaclient.networking.data.UserRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

class ActivityItemViewModel : ViewModel(){

    private val repository = UserRepository()

    private val userListLiveData = MutableLiveData<List<ActivityItem>>(emptyList())

    private var currentSearchJob: Job? = null

    val userList: LiveData<List<ActivityItem>>
        get() = userListLiveData

    fun getId() {
        currentSearchJob?.cancel()
        currentSearchJob = viewModelScope.launch {
            runCatching {
                repository.getActivityById()
            }.onSuccess {
                userListLiveData.postValue(it)
            }.onFailure {
                Timber.e(it)
                userListLiveData.postValue(null)
            }
        }
    }
}