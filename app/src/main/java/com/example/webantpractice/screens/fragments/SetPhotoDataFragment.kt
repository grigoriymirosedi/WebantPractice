package com.example.webantpractice.screens.fragments

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.webantpractice.R
import com.example.webantpractice.databinding.FragmentPhotoGalleryBinding
import com.example.webantpractice.databinding.FragmentSetPhotoDataBinding


class SetPhotoDataFragment : Fragment() {

    private lateinit var binding: FragmentSetPhotoDataBinding

    val args: SetPhotoDataFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSetPhotoDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setPhotoDataToolbar.setNavigationOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_setPhotoDataFragment_to_photoGalleryFragment)
        }
        binding.photoImageIv.setImageURI(args.selectedImage.toUri())
    }
}