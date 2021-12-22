package com.example.iihfstatisticandnews.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.iihfstatisticandnews.data.database.AppDatabase
import com.example.iihfstatisticandnews.data.mappers.MapperTeam
import com.example.iihfstatisticandnews.data.network.retrofit.ApiFactory
import com.example.iihfstatisticandnews.domain.pojo.TeamItem
import com.example.iihfstatisticandnews.domain.repositories.RepositoryTeam

class RepositoryTeamImpl(application: Application) : RepositoryTeam {

    private val apiService = ApiFactory.apiService
    private val db = AppDatabase.getInstance(application).dbDao()
    private val mapper = MapperTeam()

    override fun getTeamList(): LiveData<List<TeamItem>> {
        return Transformations.map(db.getTeamList()){
            it.map { mapper.mapDbModelToEntity(it) }
        }
    }

    override fun getTeam(team: String): LiveData<TeamItem> {
        return Transformations.map(db.getTeam(team)){
            mapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun loadTeam() {
        try {
            val dto = apiService.loadTeams()
            val dbModel = dto.map { mapper.mapDtoToDbModel(it) }
            db.insertTeamList(dbModel)
        }catch (e:Exception){
        }
    }

}