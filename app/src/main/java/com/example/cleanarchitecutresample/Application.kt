package com.example.cleanarchitecutresample

import android.app.Activity
import android.app.Application
import android.app.Service
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.IBinder
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Application : Application()