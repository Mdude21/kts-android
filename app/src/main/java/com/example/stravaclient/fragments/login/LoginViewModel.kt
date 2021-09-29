package com.example.stravaclient.fragments.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _inputValidData = MutableLiveData<Boolean>()

    val inputValidData : LiveData<Boolean> = _inputValidData

    fun validateInput(email: String, password: String)
    {
        _inputValidData.value = isEmailValid(email) && isPasswordValid(password)
    }

    private fun isEmailValid(email: String) : Boolean
    {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(password: String) : Boolean
    {
        return password.length >= 8
    }
}