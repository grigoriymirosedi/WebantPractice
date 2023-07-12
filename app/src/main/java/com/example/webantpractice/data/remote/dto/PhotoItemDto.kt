package com.example.webantpractice.data.remote.dto

import com.example.webantpractice.domain.model.PhotoItem

data class PhotoItemDto(
    val dateCreate: String,
    val description: String,
    val id: Int,
    val image: ImageItemDto,
    val name: String,
    val new: Boolean,
    val popular: Boolean,
    val user: String
) {
    fun toPhotoItem(): PhotoItem = PhotoItem(
        dateCreate = dateCreate,
        description = description,
        id = id,
        image = image.toImageItem(),
        name = name,
        new = new,
        popular = popular,
        user = user
    )
}