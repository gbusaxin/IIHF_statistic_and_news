package com.example.iihfstatisticandnews.data.network.retrofit

import com.example.iihfstatisticandnews.data.network.models.*
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("iihf_tourney.json")
    suspend fun loadTourney(): List<TourneyDto>

    @GET("iihf_stadiums.json")
    suspend fun loadStadiums(): List<StadiumDto>

    @GET("iihf_news.json")
    suspend fun loadNews(): List<NewsDto>

    @GET("iihf_teams.json")
    suspend fun loadTeams(): List<TeamDto>

    @POST("splash.php")
    fun sendLocale(@Body locale:RequestDto): Call<ResponseDto>

}