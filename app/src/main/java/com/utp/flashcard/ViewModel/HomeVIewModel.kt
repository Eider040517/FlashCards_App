package com.utp.flashcard.ViewModel

import androidx.lifecycle.ViewModel
import com.utp.flashcard.database.entities.Pack
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel() : ViewModel() {

    private val _packs = MutableStateFlow<List<Pack>>(emptyList())
    val pack: StateFlow<List<Pack>>
        get() = _packs





    fun addNewCar(newPack : Pack){
        _packs.value += newPack
    }

    // Eliminar el Pack


}