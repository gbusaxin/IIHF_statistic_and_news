package com.example.iihfstatisticandnews.presentation.ui.teams

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.iihfstatisticandnews.data.RepositoryTeamImpl
import com.example.iihfstatisticandnews.domain.use_cases.GetTeamListUseCase
import com.example.iihfstatisticandnews.domain.use_cases.GetTeamUseCase
import com.example.iihfstatisticandnews.domain.use_cases.LoadTeamUseCase
import kotlinx.coroutines.launch

class TeamViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = RepositoryTeamImpl(application)

    private val getTeamsListUseCase = GetTeamListUseCase(repository)
    private val getTeamUseCase = GetTeamUseCase(repository)
    private val loadTeamUseCase = LoadTeamUseCase(repository)

    val teamList = getTeamsListUseCase()

    fun getTeam(team: String) = getTeamUseCase(team)

    init {
        viewModelScope.launch {
            loadTeamUseCase()
        }
    }
}