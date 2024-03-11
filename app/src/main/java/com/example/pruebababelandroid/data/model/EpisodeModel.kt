package com.example.pruebababelandroid.data.model

import com.google.gson.annotations.SerializedName

data class EpisodeModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("air_date") val airDate: String,
    @SerializedName("episode") val episode: String,
    @SerializedName("type") val characters: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
)