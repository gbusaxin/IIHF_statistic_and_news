package com.example.iihfstatisticandnews.domain.pojo

import androidx.annotation.Keep

@Keep
data class NewsItem(
    val date: String,
    val title: String,
    val body: String
)