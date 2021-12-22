package com.example.iihfstatisticandnews.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iihfstatisticandnews.R
import com.example.iihfstatisticandnews.databinding.ItemMatchBinding
import com.example.iihfstatisticandnews.domain.pojo.MatchItem

class AdapterMatch : RecyclerView.Adapter<AdapterMatch.ViewHolderMatch>() {
    inner class ViewHolderMatch(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemMatchBinding.bind(itemView)
        val title = binding.textViewMatchTitle
        val date = binding.textViewMatchDate
    }

    var list = listOf<MatchItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMatch {
        return ViewHolderMatch(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_match, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderMatch, position: Int) {
        val item = list[position]
        with(holder){
            title.text = item.title
            date.text = item.date
        }
    }

    override fun getItemCount() = list.size
}