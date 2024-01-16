package com.betrybe.trybnb.data.network

import com.betrybe.trybnb.data.api.AuthClient
import com.betrybe.trybnb.data.models.Login
import com.betrybe.trybnb.data.models.Token

class AuthData {
    private val authService = AuthClient.instance

    suspend fun getToken(email: String, password: String): Token? =
        authService.auth(Login(email, password)).takeIf { it.isSuccessful }?.body()
}
