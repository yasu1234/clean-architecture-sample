package com.example.cleanarchitecutresample.datastore.session

import com.example.cleanarchitecutresample.constant.HeaderTokenConstant
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val chainRequest = chain.request()
            .newBuilder()
            .addHeader(
                "Accept",
                "application/json"
            )
            .addHeader(
                "Content-Type",
                "application/json"
            )
            .addHeader(
                "Authorization",
                HeaderTokenConstant.HeaderToken
            )
        return chain.proceed(chainRequest.build())
    }
}


