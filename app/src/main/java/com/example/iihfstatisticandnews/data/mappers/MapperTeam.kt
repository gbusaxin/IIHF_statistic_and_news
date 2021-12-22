package com.example.iihfstatisticandnews.data.mappers

import com.example.iihfstatisticandnews.data.models.TeamDbModel
import com.example.iihfstatisticandnews.data.network.models.TeamDto
import com.example.iihfstatisticandnews.domain.pojo.TeamItem
import java.util.*

class MapperTeam {
    fun mapDbModelToEntity(dbModel:TeamDbModel) = TeamItem(
        country = dbModel.country,
        image = dbModel.image,
        players = dbModel.players,
        matches = dbModel.matches
    )

    fun mapDtoToDbModel(dto:TeamDto) = TeamDbModel(
        country = dto.country?:"",
        image = dto.image?:"",
        players = dto.players?:Collections.emptyList(),
        matches = dto.matches?:Collections.emptyList()
    )
}