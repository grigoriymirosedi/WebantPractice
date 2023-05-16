package com.example.webantpractice.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.webantpractice.R
import com.example.webantpractice.databinding.FragmentUserProfileSettingsBinding


class UserProfileSettingsFragment : Fragment() {

    private lateinit var binding: FragmentUserProfileSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserProfileSettingsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.userProfileSettingsToolbar.setNavigationOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_userProfileSettingsFragment_to_userProfileFragment)
        }
    }

}