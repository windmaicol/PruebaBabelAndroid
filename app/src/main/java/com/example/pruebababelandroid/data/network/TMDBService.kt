package com.example.pruebababelandroid.data.network

import com.example.pruebababelandroid.data.model.ResultsEpisodeModel
import com.example.pruebababelandroid.data.model.ResultsCharactersModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TMDBService @Inject constructor(private val api: TMDBApiClient) {

    suspend fun getEpisodes(): ResultsEpisodeModel {
        return withContext(Dispatchers.IO) {
            val response = api.getEpisodes()
            response.body()!!
        }
    }

    suspend fun getCharacters(): ResultsCharactersModel {
        return withContext(Dispatchers.IO) {
            val response = api.getCharacters()
            response.body()!!
        }
    }
}