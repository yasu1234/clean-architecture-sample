package com.example.cleanarchitecutresample.datastore.request

import android.content.Context
import com.example.cleanarchitecutresample.datastore.session.ApiClientManager
import com.example.cleanarchitecutresample.entity.User
import com.example.cleanarchitecutresample.repository.UserRequestInterface

class UserRequestFactory {
    fun createAppUpdateRequest(): UserRequestInterface {
        return UserRequest()
    }

    fun createAppUpdateStubRequest(): UserRequestInterface {
        return UserRequestStub()
    }
}

class UserRequest: UserRequestInterface {
    override suspend fun getUser(context: Context): User {
        return ApiClientManager().getApiClient(context).getUser()
    }
}

class UserRequestStub: UserRequestInterface {
    override suspend fun getUser(context: Context): User {
        return User()
    }
}