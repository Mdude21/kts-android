package com.example.stravaclient.networking.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stravaclient.networking.RemoteUser
import com.example.stravaclient.networking.data.UserRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UserListViewModel : ViewModel() {

    private val repository = UserRepository()

    private val userListLiveData = MutableLiveData<List<RemoteUser>>(emptyList())
    private val isLoadingLiveData = MutableLiveData(false)

    private var currentSearchJob: Job? = null
    val userList: LiveData<List<RemoteUser>>
        get() = userListLiveData

    val isLoading: LiveData<Boolean>
        get() = isLoadingLiveData

    fun search() {
        isLoadingLiveData.postValue(true)
        currentSearchJob?.cancel()
        currentSearchJob = viewModelScope.launch {
            kotlin.runCatching {
                repository.getAthlete()
            }.onSuccess {
                isLoadingLiveData.postValue(false)
//                userListLiveData.postValue(it)
            }.onFailure {
                isLoadingLiveData.postValue(false)
                userListLiveData.postValue(emptyList())
            }
        }
    }
}