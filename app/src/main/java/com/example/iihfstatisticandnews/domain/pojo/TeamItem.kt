package com.example.iihfstatisticandnews.domain.pojo

import androidx.annotation.Keep

@Keep
data class TeamItem(
    val country: String,
    val image: String,
    val players: List<PlayerItem>,
    val matches: List<MatchItem>
)