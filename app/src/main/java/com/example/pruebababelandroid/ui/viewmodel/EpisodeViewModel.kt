package com.example.pruebababelandroid.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebababelandroid.domain.GetAllEpisodeUseCase
import com.example.pruebababelandroid.domain.GetDataWithFIlterUseCase
import com.example.pruebababelandroid.domain.model.Episode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
/**
 * Viewmodel de episodios
 */
@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val getAllEpisodesUseCase: GetAllEpisodeUseCase,
    private val getDataWithFIlterUseCase: GetDataWithFIlterUseCase,

    ) : ViewModel() {

    val episodes = MutableLiveData<List<Episode>>()
    val isLoading = MutableLiveData<Boolean>()
    /**
     * metodo para llamar al servicio de obtemer episodios
     */
    fun getAllEpisodes() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val charactersUse = getAllEpisodesUseCase()
            charactersUse.let {
                episodes.value = it
            }
            isLoading.postValue(false)
        }
    }
    /**
     * metodo para filtrar episodios
     */
    fun getDataWithFilter(order : String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            if(order.isEmpty()){
                val getDataUse = getAllEpisodesUseCase()
                getDataUse.let {
                    episodes.value = it
                }
            }else{
                val getDataUse = getDataWithFIlterUseCase(order)
                getDataUse.let {
                    episodes.value = it
                }
            }
            isLoading.postValue(false)
        }
    }
}