package com.example.project1662.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project1662.Adapter.NearbyAdapter
import com.example.project1662.Adapter.RecommendedAdapter
import com.example.project1662.Domain.PropertyDomain
import com.example.project1662.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var adapterRecommended: RecyclerView.Adapter<*>? = null
    private var adapterNearby: RecyclerView.Adapter<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        initLocation()
        initRecyclerView()
        setupBottomNavigation()
    }

    private fun initLocation() {
        val items = arrayOf("Istanbul Turkey", "Ankara Turkey")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding!!.locationSpin.adapter = adapter
    }

    private fun initRecyclerView() {
        val items = ArrayList<PropertyDomain>()

        items.add(PropertyDomain(
            "Apartment",
            "Royal Apartment",
            "Istanbul Turkey",
            "h_1",
            1500,
            2,
            3,
            true,
            4.5,
            "This 2 bed /1 bath home boasts an enormous open-living plan accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors crowned by stunning coffered ceilings."
        ))
        items.add(PropertyDomain(
            "House",
            "House with Great View",
            "Ankara Turkey",
            "h_2",
            800,
            1,
            2,
            false,
            4.9,
            "This 2 bed /1 bath home boasts an enormous open-living plan accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors crowned by stunning coffered ceilings."
        ))
        items.add(PropertyDomain(
            "Villa",
            "Royal Villa",
            "Istanbul Turkey",
            "h_3",
            999,
            2,
            1,
            true,
            4.7,
            "This 2 bed /1 bath home boasts an enormous open-living plan accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors crowned by stunning coffered ceilings."
        ))
        items.add(PropertyDomain(
            "Apartment",
            "Modern Apartment",
            "Istanbul Turkey",
            "h_4",
            1200,
            2,
            2,
            true,
            4.6,
            "This modern 2 bed / 2 bath apartment is located in the heart of Istanbul with easy access to public transport and a vibrant neighborhood."
        ))
        items.add(PropertyDomain(
            "Apartment",
            "City View Apartment",
            "Ankara Turkey",
            "h_5",
            1800,
            3,
            2,
            true,
            4.8,
            "Enjoy stunning city views from this 3 bed / 2 bath apartment in Ankara, featuring modern amenities and a spacious layout."
        ))
        items.add(PropertyDomain(
            "Villa",
            "Beachside Villa",
            "Istanbul Turkey",
            "h_6",
            2500,
            4,
            3,
            true,
            4.9,
            "This luxurious 4 bed / 3 bath villa is located near the beach and offers stunning ocean views and premium facilities."
        ))
        items.add(PropertyDomain(
            "Villa",
            "Mountain Villa",
            "Ankara Turkey",
            "h_7",
            2200,
            3,
            3,
            true,
            4.7,
            "A beautiful 3 bed / 3 bath villa located in the mountains of Ankara, offering breathtaking views and peaceful surroundings."
        ))
        items.add(PropertyDomain(
            "House",
            "Country House",
            "Ankara Turkey",
            "h_8",
            1300,
            3,
            2,
            false,
            4.5,
            "This charming 3 bed / 2 bath country house in Ankara provides a serene living experience with modern comforts."
        ))
        items.add(PropertyDomain(
            "House",
            "Suburban House",
            "Istanbul Turkey",
            "h_9",
            1400,
            3,
            2,
            true,
            4.6,
            "A cozy 3 bed / 2 bath house in the suburbs of Istanbul, perfect for families looking for a quiet neighborhood."
        ))

        binding!!.recommendedView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapterRecommended = RecommendedAdapter(items)
        binding!!.recommendedView.adapter = adapterRecommended
        binding!!.nearbyView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterNearby = NearbyAdapter(items)
        binding!!.nearbyView.adapter = adapterNearby
    }

    private fun setupBottomNavigation() {
        binding!!.Home.setOnClickListener {
            // Handle Home icon click
            Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
            // Optionally refresh the content of the main screen
            refreshMainContent()
        }
        binding!!.Favorite.setOnClickListener {
            // Navigate to Favorite
            val intent = Intent(this, FavoriteActivity::class.java)
            startActivity(intent)
        }
        binding!!.Chat.setOnClickListener {
            // Navigate to Chat
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
        binding!!.Profile.setOnClickListener {
            // Navigate to Profile
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun refreshMainContent() {
        // Refresh or update the main content e.g. reload the RecyclerView data
        initRecyclerView()
    }
}
