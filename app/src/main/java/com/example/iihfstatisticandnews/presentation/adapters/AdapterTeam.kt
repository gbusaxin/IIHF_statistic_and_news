package com.example.iihfstatisticandnews.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iihfstatisticandnews.R
import com.example.iihfstatisticandnews.databinding.ItemTeamBinding
import com.example.iihfstatisticandnews.domain.pojo.TeamItem
import com.example.iihfstatisticandnews.presentation.ui.teams.TeamDialogFragment
import com.squareup.picasso.Picasso

class AdapterTeam (val fm:FragmentManager) : RecyclerView.Adapter<AdapterTeam.ViewHolderTeam>() {
    inner class ViewHolderTeam(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemTeamBinding.bind(itemView)
        val image = binding.imageViewTeamImage
        val country = binding.textViewTeamCountry
    }

    var onTeamClickListener:((TeamItem) -> Unit)? = null

    var list = listOf<TeamItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTeam {
        return ViewHolderTeam(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_team, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderTeam, position: Int) {
        val item = list[position]
        with(holder){
            Picasso.get().load(item.image).into(image)
            country.text = item.country
        }
        holder.itemView.setOnClickListener {
            onTeamClickListener?.invoke(item)
            var dialog = TeamDialogFragment(item)
            dialog.show(fm,"")
        }
    }

    override fun getItemCount() = list.size
}