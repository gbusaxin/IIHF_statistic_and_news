package com.example.iihfstatisticandnews.data.mappers

import com.example.iihfstatisticandnews.data.models.TourneyDbModel
import com.example.iihfstatisticandnews.data.network.models.TourneyDto
import com.example.iihfstatisticandnews.domain.pojo.TourneyItem

class MapperTourney {

    fun mapDbModelToEntity(dbModel:TourneyDbModel) = TourneyItem(
        image1 = dbModel.image1,
        image2 = dbModel.image2,
        enemy1 = dbModel.enemy1,
        enemy2 = dbModel.enemy2,
        date = dbModel.date,
        group = dbModel.group,
        result = dbModel.result
    )

    fun mapDtoToDbModel(dto:TourneyDto) = TourneyDbModel(
        image1 = dto.image1?:"",
        image2 = dto.image2?:"",
        enemy1 = dto.enemy1?:"",
        enemy2 = dto.enemy2?:"",
        date = dto.date?:"",
        group = dto.group?:"",
        result = dto.result?:""
    )
}