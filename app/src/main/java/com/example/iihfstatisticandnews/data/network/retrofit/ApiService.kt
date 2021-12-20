package com.example.iihfstatisticandnews.data.network.retrofit

import com.example.iihfstatisticandnews.data.network.models.TourneyDto
import com.example.iihfstatisticandnews.domain.pojo.TourneyItem
import retrofit2.http.GET

interface ApiService {

    @GET("iihf_tourney.json")
    suspend fun loadTourney():List<TourneyDto>
}