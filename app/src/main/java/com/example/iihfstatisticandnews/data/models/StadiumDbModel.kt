package com.example.iihfstatisticandnews.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stadium_info")
data class StadiumDbModel (
    @PrimaryKey
    val name: String,

    val image: String,

    val capacity: String,

    val country: String,

    val city: String,

    val info: String
)