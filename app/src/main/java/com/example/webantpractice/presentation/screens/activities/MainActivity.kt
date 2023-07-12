package com.example.webantpractice.presentation.screens.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.webantpractice.R
import com.example.webantpractice.core.PhotoClient
import com.example.webantpractice.data.repository.PhotoRepositoryImpl
import com.example.webantpractice.databinding.ActivityMainBinding
import com.example.webantpractice.presentation.screens.viewmodels.PhotoViewModel
import com.example.webantpractice.presentation.screens.viewmodels.PhotoViewModelProviderFactory

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.fragment)
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}