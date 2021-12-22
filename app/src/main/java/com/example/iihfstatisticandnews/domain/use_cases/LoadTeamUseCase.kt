package com.example.iihfstatisticandnews.domain.use_cases

import com.example.iihfstatisticandnews.domain.repositories.RepositoryTeam

class LoadTeamUseCase(private val repository:RepositoryTeam) {
    suspend operator fun invoke() = repository.loadTeam()
}