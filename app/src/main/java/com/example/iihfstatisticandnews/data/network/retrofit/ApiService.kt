package com.example.iihfstatisticandnews.data.network.retrofit

import com.example.iihfstatisticandnews.data.network.models.NewsDto
import com.example.iihfstatisticandnews.data.network.models.StadiumDto
import com.example.iihfstatisticandnews.data.network.models.TeamDto
import com.example.iihfstatisticandnews.data.network.models.TourneyDto
import retrofit2.http.GET

interface ApiService {

    @GET("iihf_tourney.json")
    suspend fun loadTourney(): List<TourneyDto>

    @GET("iihf_stadiums.json")
    suspend fun loadStadiums(): List<StadiumDto>

    @GET("iihf_news.json")
    suspend fun loadNews(): List<NewsDto>

    @GET("iihf_teams.json")
    suspend fun loadTeams(): List<TeamDto>

}