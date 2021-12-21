package com.example.iihfstatisticandnews.domain.use_cases

import com.example.iihfstatisticandnews.domain.repositories.RepositoryStadium

class GetStadiumListUseCase(private val repository:RepositoryStadium) {
    operator fun invoke() = repository.getStadiumList()
}