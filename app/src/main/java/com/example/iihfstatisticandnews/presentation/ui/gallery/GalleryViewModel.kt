package com.example.iihfstatisticandnews.presentation.ui.gallery

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.iihfstatisticandnews.data.RepositoryStadiumImpl
import com.example.iihfstatisticandnews.data.RepositoryTourneyImpl
import com.example.iihfstatisticandnews.domain.use_cases.GetStadiumListUseCase
import com.example.iihfstatisticandnews.domain.use_cases.GetTourneyListUseCase
import com.example.iihfstatisticandnews.domain.use_cases.LoadStadiumUseCase
import com.example.iihfstatisticandnews.domain.use_cases.LoadTourneyUseCase
import kotlinx.coroutines.launch

class GalleryViewModel(application: Application):AndroidViewModel(application) {

    private val repositoryT = RepositoryTourneyImpl(application)
    private val repositoryS = RepositoryStadiumImpl(application)

    private val getTourneyListUseCase = GetTourneyListUseCase(repositoryT)
    private val loadTourneyListUseCase = LoadTourneyUseCase(repositoryT)

    private val getStadiumListUseCase = GetStadiumListUseCase(repositoryS)
    private val loadStadiumListUseCase = LoadStadiumUseCase(repositoryS)

    val tourneyList = getTourneyListUseCase()
    val stadiumList = getStadiumListUseCase()

    init {
        viewModelScope.launch {
            loadTourneyListUseCase()
            loadStadiumListUseCase()
        }
    }

}