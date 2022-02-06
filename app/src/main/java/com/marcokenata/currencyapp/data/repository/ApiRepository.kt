package com.marcokenata.currencyapp.data.repository

import com.marcokenata.currencyapp.data.api.ApiHelper
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}