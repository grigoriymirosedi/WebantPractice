package com.example.webantpractice.presentation.screens.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.Navigation
import com.example.webantpractice.R
import com.example.webantpractice.databinding.FragmentPhotoGalleryBinding


class PhotoGalleryFragment : Fragment() {

    private lateinit var binding: FragmentPhotoGalleryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotoGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pickMultipleMedia =
            registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                // Callback is invoked after the user selects media items or closes the
                // photo picker.
                if (uri != null) {
                    val action =
                        PhotoGalleryFragmentDirections.actionPhotoGalleryFragmentToSetPhotoDataFragment(
                            uri.toString()
                        )
                    Navigation.findNavController(binding.root).navigate(action)
                } else {
                    binding.errorImageSelectedIv.visibility = View.VISIBLE
                    binding.errorImageTv.visibility = View.VISIBLE
                }
            }
        pickMultipleMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

}