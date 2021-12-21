package com.example.iihfstatisticandnews.data.network.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class NewsDto (
    @SerializedName("title")
    @Expose
    val title: String? = null,

    @SerializedName("date")
    @Expose
    val date: String? = null,

    @SerializedName("body")
    @Expose
    val body: String? = null
    )