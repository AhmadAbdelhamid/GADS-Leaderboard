package com.example.gadsleaderboard.network.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NetworkServiceGenerator {

   private fun getHttpClient(): OkHttpClient {
        val interceptorBuilder = OkHttpClient().newBuilder()
            .addInterceptor(apiInterceptor())
            .addInterceptor(loggingInterceptor())
        return interceptorBuilder.build()
    }

     private fun retrofitClient(): Retrofit {
       return  Retrofit.Builder().baseUrl(ApiConstants.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
           .client(getHttpClient()).build()
    }

    fun getLearnerServiceService(): LearnerService {
        return retrofitClient().create(LearnerService::class.java)
    }




}