package com.example.cleanarchitecutresample.datastore.session

import com.example.cleanarchitecutresample.constant.ApiConstant
import com.example.cleanarchitecutresample.entity.User
import retrofit2.http.*

interface ApiClient {
    @GET(ApiConstant.AuthenticatedUser)
    suspend fun getUser(): User
}