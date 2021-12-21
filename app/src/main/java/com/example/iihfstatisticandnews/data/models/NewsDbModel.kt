package com.example.iihfstatisticandnews.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_info")
data class NewsDbModel(
    val date: String,
    @PrimaryKey
    val title: String,
    val body: String
)