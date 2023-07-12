package com.example.webantpractice.data.remote.api

import com.example.webantpractice.data.remote.dto.PhotoResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface PhotoApi {

    @GET("/api/photos")
    suspend fun getPhotos(): Response<PhotoResponseDto>

    companion object {
        const val BASE_URL = "https://gallery.prod1.webant.ru"
    }
}