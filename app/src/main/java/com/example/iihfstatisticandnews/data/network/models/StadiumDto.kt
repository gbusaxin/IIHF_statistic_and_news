package com.example.iihfstatisticandnews.data.network.models

import androidx.annotation.Keep
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Keep
data class StadiumDto(
    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("image")
    @Expose
    val image: String? = null,

    @SerializedName("capacity")
    @Expose
    val capacity: String? = null,

    @SerializedName("country")
    @Expose
    val country: String? = null,

    @SerializedName("city")
    @Expose
    val city: String? = null,

    @SerializedName("info")
    @Expose
    val info: String? = null
)