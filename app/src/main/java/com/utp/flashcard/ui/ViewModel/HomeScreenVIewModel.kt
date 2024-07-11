package com.utp.flashcard.ui.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class CardPack(
    val id: Int,
    val title: String,
    val id_colletion: Int
)

class HomeViewModel : ViewModel() {



    private val _packs = MutableStateFlow<List<CardPack>>(emptyList())
    val pack: StateFlow<List<CardPack>>
        get() = _packs
    init {
        loadPacks()
    }

    private fun loadPacks() {
        viewModelScope.launch {
            _packs.value = listOf(
                CardPack(1, "Pack 1", 1 ),
                CardPack(2, "Pack 2", 2 )
            )
        }
    }

    //ALMACENAMIENTO EN CACH
    fun addNewCar(newPack : CardPack){
        viewModelScope.launch {
            val updatedPacks = _packs.value.toMutableList()
            updatedPacks.add(newPack)
            _packs.value = updatedPacks
        }
    }

    // Eliminar el Pack


}