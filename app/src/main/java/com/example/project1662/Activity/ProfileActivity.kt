package com.example.project1662.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project1662.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Optionally set up data or add listeners
    }
}
