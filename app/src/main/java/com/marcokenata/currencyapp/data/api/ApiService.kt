package com.marcokenata.currencyapp.data.api

import com.marcokenata.currencyapp.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers() : Response<List<User>>
}