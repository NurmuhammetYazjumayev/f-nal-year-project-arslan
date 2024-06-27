package com.example.project1662.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.project1662.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    var binding: ActivityIntroBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.introBtn.setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    this@IntroActivity,
                    MainActivity::class.java
                )
            )
        }
    }
}