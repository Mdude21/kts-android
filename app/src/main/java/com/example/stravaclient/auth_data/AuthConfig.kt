package com.example.stravaclient.auth_data

import net.openid.appauth.ResponseTypeValues

object AuthConfig {

    const val AUTH_URI = "https://www.strava.com/oauth/authorize"
    const val TOKEN_URI = "https://www.strava.com/oauth/token"
    const val RESPONSE_TYPE = ResponseTypeValues.CODE
    const val SCOPE = "profile:read_all,activity:read_all"

    const val CLIENT_ID = "72089"
    const val CLIENT_SECRET = "15e79d394b22d52aebd97a987e7c2ac6258b04a6"
    const val CALLBACK_URL = "school://kts.studio/callback"
    const val APPROVAL_PROMPT = "force"
    var token : String? = null
}