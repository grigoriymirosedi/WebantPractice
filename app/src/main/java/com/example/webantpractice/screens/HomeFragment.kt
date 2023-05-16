package com.example.webantpractice.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.webantpractice.adapter.GalleryPhotoAdapter
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
        galleryRecyclerView = binding.galleryRecyclerView
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Note: delete later. Made it just to test RV
        var galleryList = listOf<GalleryPhotoItem>(
            GalleryPhotoItem("Картинка 1", "Описание 1", 1),
            GalleryPhotoItem("Картинка 2", "Описание 2", 2),
            GalleryPhotoItem("Картинка 3", "Описание 3", 3),
            GalleryPhotoItem("Картинка 4", "Описание 4", 4),
            GalleryPhotoItem("Картинка 5", "Описание 5", 5),
            GalleryPhotoItem("Картинка 6", "Описание 6", 6),
            GalleryPhotoItem("Картинка 7", "Описание 7", 7),
            GalleryPhotoItem("Картинка 8", "Описание 8", 8),
            GalleryPhotoItem("Картинка 9", "Описание 9", 9),
            GalleryPhotoItem("Картинка 10", "Описание 10", 10)
        )
        galleryRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        galleryAdapter = GalleryPhotoAdapter(galleryList)
        galleryRecyclerView.adapter = galleryAdapter
    }

}