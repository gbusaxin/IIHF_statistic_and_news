package com.example.iihfstatisticandnews.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iihfstatisticandnews.R
import com.example.iihfstatisticandnews.databinding.ItemPlayerBinding
import com.example.iihfstatisticandnews.domain.pojo.PlayerItem

class AdapterPlayer : RecyclerView.Adapter<AdapterPlayer.ViewHolderPlayer>() {
    inner class ViewHolderPlayer(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPlayerBinding.bind(itemView)
        val number = binding.textViewPlayerNumber
        val name = binding.textViewPlayerName
        val positionn = binding.textViewPlayerPosition
        val birthday = binding.textViewPlayerBirthday
    }

    var list = listOf<PlayerItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPlayer {
        return ViewHolderPlayer(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_player, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderPlayer, position: Int) {
        val item = list[position]
        with(holder){
            number.text = item.number
            name.text = item.name
            positionn.text = item.position
            birthday.text = item.birthday
        }
    }

    override fun getItemCount() = list.size
}