package com.example.iihfstatisticandnews.presentation.ui.gallery

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.iihfstatisticandnews.data.RepositoryTourneyImpl
import com.example.iihfstatisticandnews.domain.use_cases.GetTourneyListUseCase
import com.example.iihfstatisticandnews.domain.use_cases.LoadTourneyUseCase
import kotlinx.coroutines.launch

class GalleryViewModel(application: Application):AndroidViewModel(application) {

    private val repository = RepositoryTourneyImpl(application)

    private val getTourneyListUseCase = GetTourneyListUseCase(repository)
    private val loadTourneyListUseCase = LoadTourneyUseCase(repository)

    val tourneyList = getTourneyListUseCase()

    init {
        viewModelScope.launch {
            loadTourneyListUseCase()
        }
    }

}