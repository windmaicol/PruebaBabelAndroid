package com.example.pruebababelandroid.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebababelandroid.domain.GetAllCharactersUseCase
import com.example.pruebababelandroid.domain.model.Characters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
/**
 * Viewmodel de personajes
 */
@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {

    val characters = MutableLiveData<List<Characters>>()
    val isLoading = MutableLiveData<Boolean>()
    /**
     * metodo para llamar al servicio de obtemer personajes
     */
    fun getAllCharacters() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val charactersUse = getAllCharactersUseCase()
            charactersUse.let {
                characters.value = it
            }
            isLoading.postValue(false)
        }
    }
}