package com.example.iihfstatisticandnews.domain.use_cases

import com.example.iihfstatisticandnews.domain.repositories.RepositoryNews

class GetNewsUseCase(private val repository : RepositoryNews) {
    operator fun invoke(news:String) = repository.getNews(news)
}