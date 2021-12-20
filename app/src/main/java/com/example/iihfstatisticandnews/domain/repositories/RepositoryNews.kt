package com.example.iihfstatisticandnews.domain.repositories

import androidx.lifecycle.LiveData
import com.example.iihfstatisticandnews.domain.pojo.NewsItem

interface RepositoryNews {
    fun getNewsList():LiveData<List<NewsItem>>
    fun getNews(news:String):LiveData<NewsItem>
    suspend fun loadNewsList()
}