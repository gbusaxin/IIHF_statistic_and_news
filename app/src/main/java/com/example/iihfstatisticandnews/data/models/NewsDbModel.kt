package com.example.iihfstatisticandnews.data.models

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
@Keep
@Entity(tableName = "news_info")
data class NewsDbModel(
    val date: String,
    @PrimaryKey
    val title: String,
    val body: String
)