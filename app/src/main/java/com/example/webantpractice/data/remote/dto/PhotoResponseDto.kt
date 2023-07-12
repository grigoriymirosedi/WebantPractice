package com.example.webantpractice.data.remote.dto

import com.example.webantpractice.domain.model.PhotoResponse

data class PhotoResponseDto(
    val countOfPages: Int,
    val data: List<PhotoItemDto>,
    val itemsPerPage: Int,
    val totalItems: Int
) {
    fun toPhotoResponse(): PhotoResponse = PhotoResponse(
        countOfPages = countOfPages,
        data = data.map { it -> it.toPhotoItem() },
        itemsPerPage = itemsPerPage,
        totalItems = totalItems
    )
}