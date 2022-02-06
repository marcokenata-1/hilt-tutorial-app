package com.marcokenata.currencyapp.data.api

import com.marcokenata.currencyapp.data.model.User
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val service: ApiService) : ApiHelper {
    override suspend fun getUsers(): Response<List<User>> = service.getUsers()
}