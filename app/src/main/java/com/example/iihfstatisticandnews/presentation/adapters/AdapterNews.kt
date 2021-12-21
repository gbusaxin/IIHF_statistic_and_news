package com.example.iihfstatisticandnews.presentation.adapters

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iihfstatisticandnews.R
import com.example.iihfstatisticandnews.databinding.ItemNewsTitleBinding
import com.example.iihfstatisticandnews.domain.pojo.NewsItem

class AdapterNews : RecyclerView.Adapter<AdapterNews.ViewHolderNews>() {
    inner class ViewHolderNews(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemNewsTitleBinding.bind(itemView)
        val title = binding.textViewNewsTitle
        val date = binding.textViewNewsDate
    }

    var list = listOf<NewsItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onNewsItemListener: ((NewsItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNews {
        return ViewHolderNews(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_news_title, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderNews, position: Int) {
        val item = list[position]
        with(holder) {
            title.text = item.title
            date.text = item.date
        }
        holder.itemView.setOnClickListener {
            onNewsItemListener?.invoke(item)
            AlertDialog.Builder(holder.date.context)
                .setTitle(item.title)
                .setMessage(item.body)
                .setNeutralButton("Закрыть") { arg1, arg2 ->
                    arg1.cancel()
                }
                .create()
                .show()
        }
    }

    override fun getItemCount() = list.size
}