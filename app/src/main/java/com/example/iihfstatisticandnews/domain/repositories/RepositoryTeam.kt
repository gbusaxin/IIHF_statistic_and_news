package com.example.iihfstatisticandnews.domain.repositories

import androidx.lifecycle.LiveData
import com.example.iihfstatisticandnews.domain.pojo.TeamItem

interface RepositoryTeam {
    fun getTeamList():LiveData<List<TeamItem>>
    fun getTeam(team:String):LiveData<TeamItem>
    suspend fun loadTeam()
}