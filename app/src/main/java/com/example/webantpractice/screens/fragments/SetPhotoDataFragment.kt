package com.example.webantpractice.screens.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.webantpractice.R
import com.example.webantpractice.databinding.FragmentSetPhotoDataBinding


class SetPhotoDataFragment : Fragment() {

    private lateinit var binding: FragmentSetPhotoDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSetPhotoDataBinding.inflate(inflater, container, false)
        return binding.root
    }

}