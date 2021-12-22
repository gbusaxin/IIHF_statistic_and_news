package com.example.iihfstatisticandnews.domain.use_cases

import com.example.iihfstatisticandnews.domain.repositories.RepositoryTeam

class GetTeamListUseCase(private val repository:RepositoryTeam) {
    operator fun invoke() = repository.getTeamList()
}