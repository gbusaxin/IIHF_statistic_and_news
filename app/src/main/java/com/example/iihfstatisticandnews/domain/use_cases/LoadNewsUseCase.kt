package com.example.iihfstatisticandnews.domain.use_cases

import com.example.iihfstatisticandnews.domain.repositories.RepositoryNews

class LoadNewsUseCase(private val repository : RepositoryNews) {
    suspend operator fun invoke() = repository.loadNewsList()
}