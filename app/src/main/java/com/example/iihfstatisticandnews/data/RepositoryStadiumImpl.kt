package com.example.iihfstatisticandnews.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.iihfstatisticandnews.data.database.AppDatabase
import com.example.iihfstatisticandnews.data.mappers.MapperStadium
import com.example.iihfstatisticandnews.data.network.retrofit.ApiFactory
import com.example.iihfstatisticandnews.domain.pojo.StadiumItem
import com.example.iihfstatisticandnews.domain.repositories.RepositoryStadium

class RepositoryStadiumImpl(private val application: Application):RepositoryStadium {

    private val mapper = MapperStadium()
    private val dao = AppDatabase.getInstance(application).dbDao()
    private val apiService = ApiFactory.apiService

    override fun getStadiumList(): LiveData<List<StadiumItem>> {
        return Transformations.map(dao.getStadiumList()){
            it.map { mapper.mapDbModelToEntity(it) }
        }
    }

    override suspend fun loadStadium() {
        try {
           val dto = apiService.loadStadiums()
           val dbModel = dto.map { mapper.mapDtoToDbModel(it) }
           dao.insertStadiumList(dbModel)
        }catch (e:Exception){}
    }
}