package com.example.iihfstatisticandnews.data.network.models

import androidx.annotation.Keep
import com.example.iihfstatisticandnews.domain.pojo.MatchItem
import com.example.iihfstatisticandnews.domain.pojo.PlayerItem
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName



@Keep
data class TeamDto (
    @SerializedName("country")
    @Expose
    val country: String? = null,

    @SerializedName("image")
    @Expose
    val image: String? = null,

    @SerializedName("players")
    @Expose
    val players: List<PlayerItem>? = null,

    @SerializedName("matches")
    @Expose
    val matches: List<MatchItem>? = null
    )