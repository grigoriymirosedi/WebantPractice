package com.example.webantpractice.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.webantpractice.R
import com.example.webantpractice.databinding.FragmentUserProfileBinding

class UserProfileFragment : Fragment() {

    private lateinit var binding: FragmentUserProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.userProfileToolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.profile_settings -> {
                    Navigation.findNavController(binding.root).navigate(R.id.action_userProfileFragment_to_userProfileSettingsFragment)
                    true
                }
                else -> false
            }
        }
    }

}