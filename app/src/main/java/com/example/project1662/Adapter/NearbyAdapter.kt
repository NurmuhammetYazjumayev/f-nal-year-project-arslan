package com.example.project1662.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project1662.Activity.DetailActivity
import com.example.project1662.Domain.PropertyDomain
import com.example.project1662.databinding.NearbyViewholderBinding

class NearbyAdapter(private var items: ArrayList<PropertyDomain>) : RecyclerView.Adapter<NearbyAdapter.Viewholder>() {
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val binding = NearbyViewholderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class Viewholder(private val binding: NearbyViewholderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(property: PropertyDomain) {
            binding.titleTxt.text = property.title
            binding.priceTxt.text = "$${property.price}"
            binding.typeTxt.text = property.type
            binding.addressTxt.text = property.address
            binding.scoreTxt.text = property.score.toString()
            val drawableResourceId = itemView.resources
                .getIdentifier(property.picPath, "drawable", itemView.context.packageName)
            Glide.with(context!!)
                .load(drawableResourceId)
                .into(binding.pic)
            itemView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("object", property)
                }
                context!!.startActivity(intent)
            }
        }
    }
}
