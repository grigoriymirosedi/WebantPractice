package com.example.webantpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.webantpractice.databinding.ActivitySignUpBinding

private lateinit var binding: ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            finish()
            startActivity(intent)
        }

        binding.signInBtn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}