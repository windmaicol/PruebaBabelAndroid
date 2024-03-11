package com.example.pruebababelandroid.data.network

import com.example.pruebababelandroid.data.model.ResultsEpisodeModel
import com.example.pruebababelandroid.data.model.ResultsCharactersModel
import retrofit2.Response
import retrofit2.http.GET

interface TMDBApiClient {
    @GET("episode")
    suspend fun getEpisodes(): Response<ResultsEpisodeModel>

    @GET("character/?page=1")
    suspend fun getCharacters(): Response<ResultsCharactersModel>
}