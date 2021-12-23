package com.example.iihfstatisticandnews.domain.pojo

import androidx.annotation.Keep

@Keep
data class TourneyItem(
    val image1: String,
    val image2: String,
    val enemy1: String,
    val enemy2: String,
    val date: String,
    val group: String,
    val result: String
)

