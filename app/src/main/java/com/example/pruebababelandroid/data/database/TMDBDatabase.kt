package com.example.pruebababelandroid.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebababelandroid.data.database.dao.EpisodeDao
import com.example.pruebababelandroid.data.database.entities.CharacterEntity
import com.example.pruebababelandroid.data.database.entities.EpisodeEntity

@Database(entities = [EpisodeEntity::class,CharacterEntity::class], version = 1)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun getEisodesDao(): EpisodeDao
}