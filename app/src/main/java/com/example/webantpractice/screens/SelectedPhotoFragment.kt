package com.example.webantpractice.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.webantpractice.R
import com.example.webantpractice.databinding.FragmentSelectedPhotoBinding

class SelectedPhotoFragment : Fragment() {

    private lateinit var binding: FragmentSelectedPhotoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectedPhotoBinding.inflate(inflater, container, false)
        return binding.root
    }

}