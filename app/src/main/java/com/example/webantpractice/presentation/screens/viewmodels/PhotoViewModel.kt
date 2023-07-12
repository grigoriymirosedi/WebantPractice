package com.example.webantpractice.presentation.screens.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webantpractice.core.util.Resource
import com.example.webantpractice.data.remote.dto.PhotoResponseDto
import com.example.webantpractice.domain.model.PhotoResponse
import com.example.webantpractice.domain.repository.PhotoRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class PhotoViewModel(private val photoRepository: PhotoRepository): ViewModel() {

    var photoResponse: MutableLiveData<Resource<PhotoResponse>> = MutableLiveData()

    init {
        getPhotoInfo()
    }

    fun getPhotoInfo() = viewModelScope.launch {
        photoResponse.postValue(Resource.Loading())
        val response = photoRepository.getPhotos()
        photoResponse.postValue(handlePhotoResponse(response))
    }

    private fun handlePhotoResponse(response: Response<PhotoResponseDto>): Resource<PhotoResponse> {
        if (response.isSuccessful) {
            response.body()?.let{ resultResponse ->
                return Resource.Success(resultResponse.toPhotoResponse())
            }
        }
        return Resource.Error(response.message())
    }
}