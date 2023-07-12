package com.example.webantpractice.domain.repository

import com.example.webantpractice.data.remote.api.PhotoApi
import com.example.webantpractice.data.remote.dto.PhotoItemDto
import com.example.webantpractice.data.remote.dto.PhotoResponseDto
import retrofit2.Response

interface PhotoRepository {
    suspend fun getPhotos(): Response<PhotoResponseDto>
}