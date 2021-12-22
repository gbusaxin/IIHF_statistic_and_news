package com.example.iihfstatisticandnews.domain.use_cases

import com.example.iihfstatisticandnews.domain.repositories.RepositoryTeam

class GetTeamUseCase(private val repository:RepositoryTeam) {
    operator fun invoke(team:String) = repository.getTeam(team)
}