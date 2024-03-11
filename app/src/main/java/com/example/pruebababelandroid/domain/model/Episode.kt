package com.example.pruebababelandroid.domain.model

import com.example.pruebababelandroid.data.database.entities.EpisodeEntity
import com.example.pruebababelandroid.data.model.EpisodeModel

data class Episode (val id:Int, val name:String,val airDate : String ,
                   val  episode: String, val characters: List<String>?,
                    val url: String, val created: String)


fun EpisodeModel.toDomain() = Episode(id, name,airDate,episode,characters,url ,created)

fun EpisodeEntity.toDomain() = Episode(id, name,airDate,episode,null,url ,created)

