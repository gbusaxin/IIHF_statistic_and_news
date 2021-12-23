package com.example.iihfstatisticandnews.domain.pojo

import androidx.annotation.Keep

@Keep
data class StadiumItem(
    val name: String,

    val image: String,

    val capacity: String,

    val country: String,

    val city: String,

    val info: String
)