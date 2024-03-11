package com.example.pruebababelandroid.domain

import com.example.pruebababelandroid.data.TMDBRepository
import com.example.pruebababelandroid.domain.model.Episode
import javax.inject.Inject

class GetDataWithFIlterUseCase @Inject constructor(private val repository: TMDBRepository) {
    suspend operator fun invoke(name: String): List<Episode> {
        return repository.getDataWithFilterFromDataBase(name)
    }
}