package com.example.webantpractice.screens.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.webantpractice.R
import com.example.webantpractice.adapters.GalleryPhotoAdapter
import com.example.webantpractice.databinding.FragmentHomeBinding
import com.example.webantpractice.models.GalleryPhotoItem


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var galleryRecyclerView: RecyclerView
    private lateinit var galleryAdapter: GalleryPhotoAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        galleryRecyclerView = binding.galleryPhotoRv
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
        var galleryList = mutableListOf<GalleryPhotoItem>()
        for(i in 0..15) {
            galleryList.add(GalleryPhotoItem("Тестовая картинка", "Тестовое описание", drawablesList.random()))
        }

        galleryRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        galleryAdapter = GalleryPhotoAdapter(galleryList)
        galleryRecyclerView.adapter = galleryAdapter
    }

}