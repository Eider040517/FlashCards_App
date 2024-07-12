package com.utp.flashcard.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.utp.flashcard.database.entities.Collection

class ColletionViewModel : ViewModel() {

    private val _colletion = MutableStateFlow<List<Collection>>(emptyList())
    val collection : StateFlow<List<Collection>>
        get() = _colletion

    private val _collectionId = MutableStateFlow<Int?>(null)
    val collectionId: StateFlow<Int?> = _collectionId

    fun creatMyColletion(userId : Int){
        val collection = Collection("Mis Cartas",userId,"2000")
        _collectionId.value = collection.id

    }


}