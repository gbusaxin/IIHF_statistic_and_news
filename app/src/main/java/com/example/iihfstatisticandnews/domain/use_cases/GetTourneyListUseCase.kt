package com.example.iihfstatisticandnews.domain.use_cases

import com.example.iihfstatisticandnews.domain.repositories.RepositoryTourney

class GetTourneyListUseCase(private val repository:RepositoryTourney) {
    operator fun invoke() = repository.getTourneyList()
}