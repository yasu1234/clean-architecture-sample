package com.example.cleanarchitecutresample.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecutresample.entity.Resource
import com.example.cleanarchitecutresample.entity.User
import com.example.cleanarchitecutresample.usecase.UserUseCase
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class UserPresenter @Inject constructor(
    private val userUseCase: UserUseCase
) {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun getUser() = runBlocking {
        when (val response = userUseCase.getUser()) {
            is Resource.Success -> {
                val data = response.data
                _user.postValue(data)
            }
            is Resource.Error -> {
                val errorMessage = response.message
            }
        }
    }
}