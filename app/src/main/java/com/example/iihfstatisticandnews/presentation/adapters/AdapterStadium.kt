package com.example.iihfstatisticandnews.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iihfstatisticandnews.R
import com.example.iihfstatisticandnews.databinding.ItemStadiumBinding
import com.example.iihfstatisticandnews.domain.pojo.StadiumItem
import com.squareup.picasso.Picasso

class AdapterStadium : RecyclerView.Adapter<AdapterStadium.ViewHolderStadium>() {
    inner class ViewHolderStadium(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemStadiumBinding.bind(itemView)
        val image = binding.imageViewStadium
        val name = binding.textViewStadiumName
        val country = binding.textViewStadiumCountry
        val city = binding.textViewStadiumCity
        val capacity = binding.textViewStadiumCapacity
        val info = binding.textViewStadiumInfo
    }

    var list = listOf<StadiumItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderStadium {
        return ViewHolderStadium(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_stadium, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderStadium, position: Int) {
        val item = list[position]
        with(holder){
            Picasso.get().load(item.image).into(image)
            name.text = item.name
            country.text = item.country
            city.text = item.city
            capacity.text = item.capacity
            info.text = item.info
        }
    }

    override fun getItemCount() = list.size
}