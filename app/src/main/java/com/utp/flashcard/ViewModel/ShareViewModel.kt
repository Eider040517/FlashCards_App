package com.utp.flashcard.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.utp.flashcard.database.entities.Card
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ShareViewModel : ViewModel() {
    private val _cards = MutableStateFlow<List<Card>>(emptyList())
    val cards: StateFlow<List<Card>> get() = _cards

    companion object {
        private var nextId = 1
    }

    fun addCard(card: Card) {

        card.id = nextId++
        _cards.update { currentCards ->
            val updatedCards = currentCards + card
            Log.d("ShareViewModel", "Cards after add: ${updatedCards.map { it.id }}")
            updatedCards
        }
    }

    fun updateCard(id: Int, updatedCard : Card) {
        _cards.update { currentCards ->
            val updatedCards = currentCards.map { if (it.id == id) updatedCard else it }
            Log.d("ShareViewModel", "Cards after update: $updatedCards")
            updatedCards
        }
    }
}