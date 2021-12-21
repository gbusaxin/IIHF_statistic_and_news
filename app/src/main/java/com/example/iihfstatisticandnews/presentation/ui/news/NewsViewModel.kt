package com.example.iihfstatisticandnews.presentation.ui.news

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.iihfstatisticandnews.data.RepositoryNewsImpl
import com.example.iihfstatisticandnews.domain.use_cases.GetNewsListUseCase
import com.example.iihfstatisticandnews.domain.use_cases.GetNewsUseCase
import com.example.iihfstatisticandnews.domain.use_cases.LoadNewsUseCase
import kotlinx.coroutines.launch

class NewsViewModel(application: Application):AndroidViewModel(application) {
    private val repository = RepositoryNewsImpl(application)
    private val getNewsList = GetNewsListUseCase(repository)
    private val getNewsUseCase = GetNewsUseCase(repository)
    private val loadNews = LoadNewsUseCase(repository)

    val newsList = getNewsList()

    fun getNews(news:String) = getNewsUseCase(news)

    init {
        viewModelScope.launch {
            loadNews()
        }
    }
}