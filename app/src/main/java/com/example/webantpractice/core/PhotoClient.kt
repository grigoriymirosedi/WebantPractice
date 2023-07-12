package com.example.webantpractice.core

import com.example.webantpractice.data.remote.api.PhotoApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object PhotoClient {

    private val retrofit by lazy {
        var logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        Retrofit.Builder().
        baseUrl(PhotoApi.BASE_URL).
        addConverterFactory(GsonConverterFactory.create()).
        client(client).
        build()
    }


    fun providePhotoApi(): PhotoApi = retrofit.create(PhotoApi::class.java)
}