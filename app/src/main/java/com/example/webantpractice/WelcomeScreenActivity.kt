package com.example.webantpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.webantpractice.databinding.ActivityWelcomeScreenBinding

class WelcomeScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityWelcomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createNewAccountBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.alreadyHaveAccountBtn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}