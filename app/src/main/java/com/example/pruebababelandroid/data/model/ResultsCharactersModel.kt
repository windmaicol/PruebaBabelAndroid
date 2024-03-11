package com.example.pruebababelandroid.data.model

import com.google.gson.annotations.SerializedName

data class ResultsCharactersModel(
    @SerializedName("info") val page: InfoModel,
    @SerializedName("results") val results: List<CharactersModel>
)