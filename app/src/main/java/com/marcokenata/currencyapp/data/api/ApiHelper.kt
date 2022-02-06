package com.marcokenata.currencyapp.data.api

import com.marcokenata.currencyapp.data.model.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers() : Response<List<User>>
}