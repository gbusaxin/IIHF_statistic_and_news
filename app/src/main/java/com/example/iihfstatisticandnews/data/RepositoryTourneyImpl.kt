package com.example.iihfstatisticandnews.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.iihfstatisticandnews.data.database.AppDatabase
import com.example.iihfstatisticandnews.data.mappers.MapperTourney
import com.example.iihfstatisticandnews.data.network.retrofit.ApiFactory
import com.example.iihfstatisticandnews.domain.pojo.TourneyItem
import com.example.iihfstatisticandnews.domain.repositories.RepositoryTourney

class RepositoryTourneyImpl(private val application: Application) : RepositoryTourney {

    private val dao = AppDatabase.getInstance(application).dbDao()
    private val apiService = ApiFactory.apiService
    private val mapper = MapperTourney()

    override fun getTourneyList(): LiveData<List<TourneyItem>> {
        return Transformations.map(dao.getTourneyList()) {
            it.map { mapper.mapDbModelToEntity(it) }
        }
    }

    override suspend fun loadTourneyList() {
        try {
            val dto = apiService.loadTourney()
            val dbModel = dto.map { mapper.mapDtoToDbModel(it) }
            dao.insertTourneyList(dbModel)
        }catch (e:Exception){}
    }
}