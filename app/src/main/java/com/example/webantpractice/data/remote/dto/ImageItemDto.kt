package com.example.webantpractice.data.remote.dto

import com.example.webantpractice.domain.model.ImageItem

data class ImageItemDto(
    val id: Int,
    val name: String
) {
    fun toImageItem(): ImageItem = ImageItem(
        id = id,
        name = name
    )
}