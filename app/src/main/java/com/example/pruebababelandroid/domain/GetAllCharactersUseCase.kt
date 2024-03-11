package com.example.pruebababelandroid.domain

import com.example.pruebababelandroid.domain.model.Characters
import com.example.pruebababelandroid.data.TMDBRepository
import com.example.pruebababelandroid.data.database.entities.toDatabase
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(private val repository: TMDBRepository) {
    suspend operator fun invoke():List<Characters>{
        val getCharacters = repository.getAllCharacterApi()

        return if(getCharacters.isNotEmpty()){
            repository.clearCharacter()
            repository.insertCharacter(getCharacters.map { it.toDatabase() })
            getCharacters
        }else{
            repository.getAllCharacterFromDataBase()
        }
    }
}