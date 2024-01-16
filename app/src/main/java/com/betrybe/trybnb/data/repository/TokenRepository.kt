package com.betrybe.trybnb.data.repository

import com.betrybe.trybnb.data.api.AuthClient
import com.betrybe.trybnb.data.models.Login
import com.betrybe.trybnb.data.models.Token

class TokenRepository {
    private val authService = AuthClient.instance

    suspend fun isValidToken(email: String, password: String): Token? {
        val token = authService.auth(Login(email, password))
        return if (token.isSuccessful) token.body() else null
    }
}
