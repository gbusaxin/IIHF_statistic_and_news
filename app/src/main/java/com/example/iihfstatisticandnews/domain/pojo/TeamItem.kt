package com.example.iihfstatisticandnews.domain.pojo


data class TeamItem(
    val country: String,
    val image: String,
    val players: List<PlayerItem>,
    val matches: List<MatchItem>
)