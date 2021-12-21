package com.example.iihfstatisticandnews.domain.repositories

import androidx.lifecycle.LiveData
import com.example.iihfstatisticandnews.domain.pojo.StadiumItem

interface RepositoryStadium {
    fun getStadiumList():LiveData<List<StadiumItem>>
    suspend fun loadStadium()
}