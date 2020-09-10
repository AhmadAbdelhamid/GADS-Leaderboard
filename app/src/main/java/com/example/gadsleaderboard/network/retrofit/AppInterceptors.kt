package com.example.gadsleaderboard.network.retrofit

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

//add API Key in each request
fun apiInterceptor(): Interceptor {
    return object : Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val httpUrl = originalRequest.url.newBuilder().build()
            val _request = originalRequest.newBuilder().url(httpUrl).build()
            return chain.proceed(_request)        }

    }
}

//logging interceptor for debug
fun loggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.HEADERS)
        .setLevel(HttpLoggingInterceptor.Level.BODY)
        .setLevel(HttpLoggingInterceptor.Level.BASIC)
}