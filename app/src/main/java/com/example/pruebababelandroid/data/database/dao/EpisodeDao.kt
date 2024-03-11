package com.example.pruebababelandroid.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebababelandroid.data.database.entities.CharacterEntity
import com.example.pruebababelandroid.data.database.entities.EpisodeEntity
import com.example.pruebababelandroid.domain.model.Episode

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM episode_table ORDER BY id DESC")
    suspend fun getEpisodesDao():List<EpisodeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertsEpisodes(episode:List<EpisodeEntity>)

    @Query("DELETE FROM episode_table")
    suspend fun deleteAllEpisodes()

    @Query("SELECT * FROM character_table ORDER BY id DESC")
    suspend fun getCharacterDao():List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(students:List<CharacterEntity>)

    @Query("DELETE FROM character_table")
    suspend fun deleteAllCharacters()

    @Query("SELECT * FROM episode_table WHERE name LIKE '%' || :name || '%' OR episode LIKE '%' || :name || '%'")
    suspend fun getDataWithFilterDao(name : String):List<EpisodeEntity>

}