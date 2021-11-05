package com.example.stravaclient.fragments.athlete

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stravaclient.R
import com.example.stravaclient.models.Users
import com.example.stravaclient.networking.data.models.AthleteItem
import com.example.stravaclient.networking.data.UserRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AthleteViewModel : ViewModel(){

    private val repository = UserRepository()

    private val userInfoLiveData = MutableLiveData<AthleteItem?>(null)

    private val _failToast = MutableLiveData<Int>()

    private var currentInfoJob: Job? = null

    val userInfo: LiveData<AthleteItem?>
        get() = userInfoLiveData

    val failToast: LiveData<Int>
        get() = _failToast



    fun getUserInfo(){
        currentInfoJob?.cancel()

        currentInfoJob = viewModelScope.launch {
            runCatching {
                repository.getAthlete()
            }.onSuccess {
                userInfoLiveData.postValue(it)
                val user = Users(
                    id = it.id,
                    firstname = it.firstname,
                    lastname = it.lastname,
                    profile = it.avatar,
                    followers = it.countFollowers,
                    friends = it.countFriends,
                    createdAt = it.date
                )
                repository.saveUser(user)

            }.onFailure {
                val user = repository.getAllUsers()
                val item = AthleteItem(
                    firstname = user.firstname,
                    lastname = user.lastname,
                    avatar = user.profile,
                    countFollowers = user.followers,
                    countFriends = user.friends,
                    date = user.createdAt,
                    id = user.id
                )
                userInfoLiveData.postValue(item)
                _failToast.postValue(R.string.push)
            }
        }
    }
}