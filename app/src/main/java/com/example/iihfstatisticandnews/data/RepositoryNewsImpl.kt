package com.example.iihfstatisticandnews.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.iihfstatisticandnews.data.database.AppDatabase
import com.example.iihfstatisticandnews.data.mappers.MapperNews
import com.example.iihfstatisticandnews.data.network.retrofit.ApiFactory
import com.example.iihfstatisticandnews.domain.pojo.NewsItem
import com.example.iihfstatisticandnews.domain.repositories.RepositoryNews

class RepositoryNewsImpl(private val application: Application) : RepositoryNews {

    private val apiService = ApiFactory.apiService
    private val dao = AppDatabase.getInstance(application).dbDao()
    private val mapper = MapperNews()

    override fun getNewsList(): LiveData<List<NewsItem>> {
        return Transformations.map(dao.getNewsList()){
            it.map { mapper.mapDbModelToEntity(it) }
        }
    }

    override fun getNews(news: String): LiveData<NewsItem> {
        return Transformations.map(dao.getNews(news)){
            mapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun loadNewsList() {
        try {
            val dto = apiService.loadNews()
            val dbModel = dto.map { mapper.mapDtoToDbModel(it) }
            dao.insertNewsList(dbModel)
        } catch (e: Exception) {
        }
    }
}