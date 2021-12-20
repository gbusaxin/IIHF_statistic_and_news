package com.example.iihfstatisticandnews.domain.repositories

import androidx.lifecycle.LiveData
import com.example.iihfstatisticandnews.domain.pojo.TourneyItem

interface RepositoryTourney {

    fun getTourneyList():LiveData<List<TourneyItem>>
    suspend fun loadTourneyList()
}