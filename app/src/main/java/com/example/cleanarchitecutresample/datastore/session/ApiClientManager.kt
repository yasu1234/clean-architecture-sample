package com.example.cleanarchitecutresample.datastore.session

import android.content.Context
import com.example.cleanarchitecutresample.constant.ApiConstant
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClientManager {
    private val gson =
        GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

    fun getApiClient(context: Context): ApiClient {
        return Retrofit.Builder()
            .client(getClient(context))
            .baseUrl(ApiConstant.apiHost)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiClient::class.java)
    }

    private fun getClient(context: Context): OkHttpClient {
        val builder = OkHttpClient
            .Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .addInterceptor(HeaderInterceptor())

        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(logger)

        return builder.build()
    }
}