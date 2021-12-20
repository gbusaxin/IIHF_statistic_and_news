package com.example.iihfstatisticandnews.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iihfstatisticandnews.R
import com.example.iihfstatisticandnews.databinding.ItemTourneyBinding
import com.example.iihfstatisticandnews.domain.pojo.TourneyItem
import com.squareup.picasso.Picasso

class AdapterTourney : RecyclerView.Adapter<AdapterTourney.ViewHolderTourney>() {
    inner class ViewHolderTourney(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemTourneyBinding.bind(itemView)
        val image1 = binding.imageViewTournamentEnemy1
        val image2 = binding.imageViewTournamentEnemy2
        val enemy1 = binding.textViewTournamentEnemy1
        val enemy2 = binding.textViewTournamentEnemy2
        val date = binding.textViewTournamentDate
        val group = binding.textViewTournamentGroup
        val result = binding.textViewTournamentResult
    }

    var list = listOf<TourneyItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTourney {
        return ViewHolderTourney(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_tourney, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderTourney, position: Int) {
        val item = list[position]
        with(holder) {
            Picasso.get().load(item.image1).into(image1)
            Picasso.get().load(item.image2).into(image2)
            enemy1.text = item.enemy1
            enemy2.text = item.enemy2
            date.text = item.date
            group.text = item.group
            result.text = item.result
        }
    }

    override fun getItemCount() = list.size
}