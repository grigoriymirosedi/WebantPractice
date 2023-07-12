package com.example.webantpractice.data.repository

import com.example.webantpractice.data.remote.api.PhotoApi
import com.example.webantpractice.data.remote.dto.PhotoResponseDto
import com.example.webantpractice.domain.repository.PhotoRepository
import retrofit2.Response

class PhotoRepositoryImpl(val photoApi: PhotoApi): PhotoRepository {

    override suspend fun getPhotos(): Response<PhotoResponseDto> {
        return photoApi.getPhotos()
    }
}