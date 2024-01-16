package com.betrybe.trybnb.data.api

import com.betrybe.trybnb.data.models.Login
import com.betrybe.trybnb.data.models.Token
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth")
    suspend fun auth(@Body bodyLogin: Login): Response<Token>
}
