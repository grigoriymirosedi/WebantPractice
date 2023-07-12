package com.example.webantpractice.domain.model

import com.example.webantpractice.data.remote.dto.PhotoItemDto

data class PhotoResponse(
    val countOfPages: Int,
    val data: List<PhotoItem>,
    val itemsPerPage: Int,
    val totalItems: Int
) {
}