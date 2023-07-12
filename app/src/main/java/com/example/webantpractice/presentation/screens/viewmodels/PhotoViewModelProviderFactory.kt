package com.example.webantpractice.presentation.screens.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.webantpractice.domain.repository.PhotoRepository

class PhotoViewModelProviderFactory(private val photoRepository: PhotoRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PhotoViewModel(photoRepository) as T
    }
}