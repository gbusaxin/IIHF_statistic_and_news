package com.example.iihfstatisticandnews.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tourney_info")
data class TourneyDbModel (
    val image1: String,
    val image2: String,
    val enemy1: String,
    val enemy2: String,
    @PrimaryKey
    val date: String,
    val group: String,
    val result: String
    )