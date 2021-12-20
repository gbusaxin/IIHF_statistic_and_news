package com.example.iihfstatisticandnews.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tourney_info")
data class TourneyDbModel (
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val image1: String,
    val image2: String,
    val enemy1: String,
    val enemy2: String,
    val date: String,
    val group: String,
    val result: String
    )