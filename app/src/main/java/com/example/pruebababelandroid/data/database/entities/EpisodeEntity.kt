package com.example.pruebababelandroid.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pruebababelandroid.domain.model.Episode

@Entity(tableName = "episode_table")
data class EpisodeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "air_date") val airDate: String,
    @ColumnInfo(name = "episode") val episode: String,
    @ColumnInfo(name = "characters") val characters: Int = 0,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "created") val created: String
)

fun Episode.toDatabase() = EpisodeEntity(id = id, name =  name,airDate = airDate,
    episode = episode, characters = 0, url = url, created = created)