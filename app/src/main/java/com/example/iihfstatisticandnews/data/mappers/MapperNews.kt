package com.example.iihfstatisticandnews.data.mappers

import com.example.iihfstatisticandnews.data.models.NewsDbModel
import com.example.iihfstatisticandnews.data.network.models.NewsDto
import com.example.iihfstatisticandnews.domain.pojo.NewsItem

class MapperNews {
    fun mapDbModelToEntity(dbModel:NewsDbModel) = NewsItem(
        date = dbModel.date,
        title = dbModel.title,
        body = dbModel.body
    )

    fun mapDtoToDbModel(dto:NewsDto) = NewsDbModel(
        date = dto.date?:"",
        title = dto.title?:"",
        body = dto.body?:""
    )
}