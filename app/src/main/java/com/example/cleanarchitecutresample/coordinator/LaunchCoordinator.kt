package com.example.cleanarchitecutresample.coordinator

import android.content.Context
import android.content.Intent
import com.example.cleanarchitecutresample.MainActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LaunchCoordinator @Inject constructor() {
    fun presentMainActivity(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }
}