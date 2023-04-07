package com.example.cleanarchitecutresample.repository

import android.content.Context
import com.example.cleanarchitecutresample.entity.User

interface UserRequestInterface {
    suspend fun getUser(context: Context): User
}

class UserRepository(val context: Context) {
    lateinit var userRequest: UserRequestInterface

    suspend fun getUser(): User {
        return userRequest.getUser(context)
    }
}