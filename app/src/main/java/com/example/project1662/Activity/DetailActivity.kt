package com.example.project1662.Activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.project1662.Domain.PropertyDomain
import com.example.project1662.R
import com.example.project1662.databinding.ActivityDetailBinding
import com.example.project1662.repository.FavoriteRepository

class DetailActivity : AppCompatActivity() {
    var binding: ActivityDetailBinding? = null
    private var property: PropertyDomain? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        getBundles()
        setVariables()

        // Set click listener for the favorite button
        binding!!.favoriteBtn.setOnClickListener {
            property?.let {
                if (FavoriteRepository.isFavorite(it)) {
                    FavoriteRepository.removeFavorite(it)
                    binding!!.favoriteBtn.setImageResource(R.drawable.favorite_icon) // Update with unfilled icon
                    Toast.makeText(this, "Removed from Favorites", Toast.LENGTH_SHORT).show()
                } else {
                    FavoriteRepository.addFavorite(it)
                    binding!!.favoriteBtn.setImageResource(R.drawable.favorite_filled_icon) // Update with filled icon
                    Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Initialize the favorite button state
        property?.let {
            if (FavoriteRepository.isFavorite(it)) {
                binding!!.favoriteBtn.setImageResource(R.drawable.favorite_filled_icon) // Update with filled icon
            } else {
                binding!!.favoriteBtn.setImageResource(R.drawable.favorite_icon) // Update with unfilled icon
            }
        }
    }

    private fun setVariables() {
        binding!!.backBtn.setOnClickListener { v: View? -> finish() }
        val drawableResourceID = resources.getIdentifier(property!!.picPath, "drawable", this@DetailActivity.packageName)
        Glide.with(this@DetailActivity)
            .load(drawableResourceID)
            .into(binding!!.picDetail)
        binding!!.titleTxt.text = property!!.title
        binding!!.typeTxt.text = property!!.type
        binding!!.addressTxt.text = property!!.address
        binding!!.descriptionTxt.text = property!!.description
        binding!!.scoreTxt.text = "" + property!!.score
        binding!!.priceTxt.text = "$" + property!!.price
        binding!!.bedTxt.text = property!!.bed.toString() + " Bed"
        binding!!.bathTxt.text = property!!.bath.toString() + " Bath"
        if (property!!.isWifi) {
            binding!!.wifiTxt.text = "Wifi"
        } else {
            binding!!.wifiTxt.text = "No Wifi"
        }
    }

    private fun getBundles() {
        property = intent.getSerializableExtra("object") as PropertyDomain?
    }
}
