package com.example.webantpractice.presentation.screens.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.webantpractice.R
import com.example.webantpractice.presentation.adapters.UserProfileGalleryAdapter
import com.example.webantpractice.databinding.FragmentUserProfileBinding
import com.example.webantpractice.presentation.models.GalleryPhotoItem

class UserProfileFragment : Fragment() {

    private lateinit var binding: FragmentUserProfileBinding
    private lateinit var userProfileGalleryRV: RecyclerView
    private lateinit var userProfileGalleryAdapter: UserProfileGalleryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        userProfileGalleryRV = binding.userProfileGalleryRv
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Note: delete later. Made it just to test RV
        val drawablesList = listOf<Int>(
            R.drawable.sample_image1, R.drawable.sample_image2,
            R.drawable.sample_image3, R.drawable.sample_image4,
            R.drawable.sample_image5, R.drawable.sample_image6,
            R.drawable.sample_image7, R.drawable.sample_image8,
            R.drawable.sample_image9, R.drawable.sample_image10,
            R.drawable.sample_image11)
        val userGalleryList = mutableListOf<GalleryPhotoItem>()
        for(i in 0..30) {
            userGalleryList.add(GalleryPhotoItem("Тестовая картинка", "Тестовое описание", drawablesList.random()))
        }

        userProfileGalleryAdapter = UserProfileGalleryAdapter(userGalleryList)
//        userProfileGalleryRV.layoutManager = GridLayoutManager(requireContext(), 4)
//        userProfileGalleryRV.adapter = userProfileGalleryAdapter
        binding.userProfileGalleryRv.layoutManager = GridLayoutManager(requireContext(), 4)
        binding.userProfileGalleryRv.adapter = userProfileGalleryAdapter

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