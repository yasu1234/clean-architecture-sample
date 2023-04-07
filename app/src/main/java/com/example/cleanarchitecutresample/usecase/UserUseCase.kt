package com.example.cleanarchitecutresample.usecase

import com.example.cleanarchitecutresample.entity.Resource
import com.example.cleanarchitecutresample.entity.User
import com.example.cleanarchitecutresample.repository.UserRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend fun getUser(): Resource<User> {
        try {
            return Resource.Success(repository.getUser())
        } catch (e: HttpException) {
            return Resource.Error("")
        } catch (e: IOException) {
            return Resource.Error("")
        }
    }
}
