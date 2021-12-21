package com.example.iihfstatisticandnews.data.mappers

import com.example.iihfstatisticandnews.data.models.StadiumDbModel
import com.example.iihfstatisticandnews.data.network.models.StadiumDto
import com.example.iihfstatisticandnews.domain.pojo.StadiumItem

class MapperStadium {

    fun mapDbModelToEntity(dbModel: StadiumDbModel) = StadiumItem(
        name = dbModel.name,
        image = dbModel.image,
        capacity = dbModel.capacity,
        country = dbModel.country,
        city = dbModel.city,
        info = dbModel.info
    )

    fun mapDtoToDbModel(dto: StadiumDto) = StadiumDbModel(
        name = dto.name?:"",
        image = dto.image?:"",
        capacity = dto.capacity?:"",
        country = dto.country?:"",
        city = dto.city?:"",
        info = dto.info?:""
    )

}