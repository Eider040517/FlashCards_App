package com.utp.flashcard.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utp.flashcard.database.PackDAO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class CardPack(
    val id: Int,
    val title: String,
    val id_colletion: Int
)

class HomeViewModel() : ViewModel() {



    private val _packs = MutableStateFlow<List<CardPack>>(emptyList())
    val pack: StateFlow<List<CardPack>>
        get() = _packs
    init {
        loadPacks()
    }

    private fun loadPacks() {

    }

    //ALMACENAMIENTO EN CACH
    fun addNewCar(newPack : CardPack){

    }

    // Eliminar el Pack


}