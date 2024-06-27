package com.example.project1662.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project1662.Adapter.NearbyAdapter
import com.example.project1662.databinding.ActivityFavoriteBinding
import com.example.project1662.repository.FavoriteRepository

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var favoriteAdapter: NearbyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        favoriteAdapter = NearbyAdapter(FavoriteRepository.getFavorites() as ArrayList)
        binding.favoriteRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.favoriteRecyclerView.adapter = favoriteAdapter
    }
}
