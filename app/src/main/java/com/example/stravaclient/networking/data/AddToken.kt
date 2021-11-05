package com.example.stravaclient.networking.data

import com.example.stravaclient.auth_data.AuthRepository
import okhttp3.Interceptor
import okhttp3.Response

class AddToken : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val token = AuthRepository.token.accessToken
        println(token)
        val originalRequest = chain.request()

        val request = if (token != null) {
            originalRequest.newBuilder()
                .header("Authorization", "Bearer $token")
                .build()
        } else {
            originalRequest
        }

        return chain.proceed(request)
    }
}