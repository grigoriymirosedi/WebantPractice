package com.example.webantpractice.domain.model

data class PhotoItem(
    val dateCreate: String,
    val description: String,
    val id: Int,
    val image: ImageItem,
    val name: String,
    val new: Boolean,
    val popular: Boolean,
    val user: String
)
