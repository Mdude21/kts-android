package com.example.stravaclient.auth_data

import android.net.Uri
import net.openid.appauth.*
import timber.log.Timber

class AuthRepository {

    fun getAuthRequest(): AuthorizationRequest{
        val serviceConfiguration = AuthorizationServiceConfiguration(
            Uri.parse(AuthConfig.AUTH_URI),
            Uri.parse(AuthConfig.TOKEN_URI)
        )

        val redirectUri = Uri.parse(AuthConfig.CALLBACK_URL)

        return AuthorizationRequest.Builder(
            serviceConfiguration,
            AuthConfig.CLIENT_ID,
            AuthConfig.RESPONSE_TYPE,
            redirectUri
        )
            .setPrompt(AuthConfig.APPROVAL_PROMPT)
            .setScope(AuthConfig.SCOPE)
            .build()
    }

    object token{
        var accessToken: String? = null
    }

    fun performTokenRequest(
        authService : AuthorizationService,
        tokenRequest: TokenRequest,
        onComplete: () -> Unit,
        onError: () -> Unit
    ) {
        authService.performTokenRequest(tokenRequest, getClientAuthentication()) { response, ex ->
            when {
                response != null -> {
                    token.accessToken = response.accessToken.orEmpty()
                    AuthConfig.token = response.accessToken.orEmpty()
                    onComplete()
                }
                else -> onError()
            }
        }
    }

    private fun getClientAuthentication(): ClientAuthentication {
        return ClientSecretPost(AuthConfig.CLIENT_SECRET)
    }
}