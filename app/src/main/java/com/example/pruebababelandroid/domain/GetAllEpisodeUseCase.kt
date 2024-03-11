package com.example.pruebababelandroid.domain

import com.example.pruebababelandroid.data.TMDBRepository
import com.example.pruebababelandroid.data.database.entities.toDatabase
import com.example.pruebababelandroid.domain.model.Episode
import javax.inject.Inject

class GetAllEpisodeUseCase @Inject constructor(private val repository: TMDBRepository) {
    suspend operator fun invoke():List<Episode>{
        val getCharacters = repository.getAllEpisodesApi()

        return if(getCharacters.isNotEmpty()){
            repository.clearEpisodes()
            repository.insertEpisodes(getCharacters.map { it.toDatabase() })
            getCharacters
        }else{
            repository.getAllEpisodesFromDataBase()
        }
    }
}