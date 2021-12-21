package com.example.iihfstatisticandnews.domain.use_cases

import com.example.iihfstatisticandnews.domain.repositories.RepositoryStadium

class LoadStadiumUseCase(private val repository:RepositoryStadium) {
    suspend operator fun invoke() = repository.loadStadium()
}