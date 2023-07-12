package com.example.webantpractice.presentation.screens.fragments

import android.os.Bundle
import android.provider.ContactsContract.Contacts.Photo
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.webantpractice.R
import com.example.webantpractice.core.PhotoClient
import com.example.webantpractice.core.util.Resource
import com.example.webantpractice.data.repository.PhotoRepositoryImpl
import com.example.webantpractice.presentation.adapters.GalleryPhotoAdapter
import com.example.webantpractice.databinding.FragmentHomeBinding
import com.example.webantpractice.presentation.adapters.PhotoAdapter
import com.example.webantpractice.presentation.models.GalleryPhotoItem
import com.example.webantpractice.presentation.screens.activities.MainActivity
import com.example.webantpractice.presentation.screens.viewmodels.PhotoViewModel
import com.example.webantpractice.presentation.screens.viewmodels.PhotoViewModelProviderFactory


class HomeFragment : Fragment() {

    lateinit var viewModel: PhotoViewModel
    private lateinit var binding: FragmentHomeBinding
    private lateinit var photoRecyclerView: RecyclerView
    private lateinit var photoAdapter: PhotoAdapter

    val TAG = "HomeFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        photoRecyclerView = binding.photoRv

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val photoRepository = PhotoRepositoryImpl(PhotoClient.providePhotoApi())
        val viewModelProviderFactory =  PhotoViewModelProviderFactory(photoRepository)
        setupPhotoRecyclerView()

        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(PhotoViewModel::class.java)
        viewModel.photoResponse.observe(viewLifecycleOwner, Observer { photoResponse ->
            when(photoResponse) {
                is Resource.Success -> {
                    hideProgressBar()
                    photoAdapter.differ.submitList(photoResponse.data?.data)
                }
                is Resource.Error -> {
                    hideProgressBar()
                    showErrorResult()
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun setupPhotoRecyclerView() {
        photoAdapter = PhotoAdapter()
        photoRecyclerView.apply {
            adapter = photoAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun showErrorResult() {
        binding.loadingErrorImage.visibility = View.VISIBLE
        binding.loadingErrorSubtitleTv.visibility = View.VISIBLE
        binding.loadingErrorTitleTv.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

}