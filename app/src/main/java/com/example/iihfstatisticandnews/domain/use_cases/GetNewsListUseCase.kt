package com.example.iihfstatisticandnews.domain.use_cases

import com.example.iihfstatisticandnews.domain.repositories.RepositoryNews

class GetNewsListUseCase(private val repository : RepositoryNews) {
    operator fun invoke() = repository.getNewsList()
}