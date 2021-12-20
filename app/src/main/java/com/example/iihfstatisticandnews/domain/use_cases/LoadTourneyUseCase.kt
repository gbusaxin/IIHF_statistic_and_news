package com.example.iihfstatisticandnews.domain.use_cases

import com.example.iihfstatisticandnews.domain.repositories.RepositoryTourney

class LoadTourneyUseCase(private val repository:RepositoryTourney) {
    suspend operator fun invoke() = repository.loadTourneyList()
}