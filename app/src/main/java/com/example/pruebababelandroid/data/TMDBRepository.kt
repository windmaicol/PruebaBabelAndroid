package com.example.pruebababelandroid.data

import com.example.pruebababelandroid.data.database.dao.EpisodeDao
import com.example.pruebababelandroid.data.database.entities.CharacterEntity
import com.example.pruebababelandroid.data.database.entities.EpisodeEntity
import com.example.pruebababelandroid.data.model.ResultsEpisodeModel
import com.example.pruebababelandroid.data.network.TMDBService
import com.example.pruebababelandroid.domain.model.Characters
import com.example.pruebababelandroid.domain.model.Episode
import com.example.pruebababelandroid.domain.model.toDomain
import com.example.pruebababelandroid.data.model.ResultsCharactersModel
import javax.inject.Inject

class TMDBRepository @Inject constructor(
    private val api: TMDBService,
    private val episodeDao: EpisodeDao) {

    suspend fun getAllEpisodesApi():List<Episode>  {
        val response: ResultsEpisodeModel = api.getEpisodes()
        return response.results.map { it.toDomain() }
    }

    suspend fun getAllEpisodesFromDataBase():List<Episode>{
        val response: List<EpisodeEntity> = episodeDao.getEpisodesDao()
        return response.map { it.toDomain() }
    }

    suspend fun insertEpisodes(episodes:List<EpisodeEntity>){
        episodeDao.insertsEpisodes(episodes)
    }

    suspend fun clearEpisodes(){
        episodeDao.deleteAllEpisodes()
    }

    suspend fun getAllCharacterApi():List<Characters>  {
        val response: ResultsCharactersModel = api.getCharacters()
        return response.results.map { it.toDomain() }
    }

    suspend fun getAllCharacterFromDataBase():List<Characters>{
        val response: List<CharacterEntity> = episodeDao.getCharacterDao()
        return response.map { it.toDomain() }
    }

    suspend fun insertCharacter(characters:List<CharacterEntity>){
        episodeDao.insertCharacter(characters)
    }

    suspend fun clearCharacter(){
        episodeDao.deleteAllCharacters()
    }

    suspend fun getDataWithFilterFromDataBase(order : String):List<Episode>{
        val response: List<EpisodeEntity> = episodeDao.getDataWithFilterDao(order)
        return response.map { it.toDomain() }
    }

}