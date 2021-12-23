package com.example.iihfstatisticandnews.data.models

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.iihfstatisticandnews.data.converters.TeamConverter
import com.example.iihfstatisticandnews.domain.pojo.MatchItem
import com.example.iihfstatisticandnews.domain.pojo.PlayerItem
@Keep
@Entity(tableName = "team_info")
@TypeConverters(TeamConverter::class)
data class TeamDbModel (
    @PrimaryKey
    val country: String,
    val image: String,
    val players: List<PlayerItem>,
    val matches: List<MatchItem>
    )