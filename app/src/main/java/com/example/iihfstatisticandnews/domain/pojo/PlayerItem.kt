package com.example.iihfstatisticandnews.domain.pojo

import androidx.annotation.Keep

@Keep
data class PlayerItem(
    val number: String,

    val name: String,

    val position: String,

    val birthday: String
)