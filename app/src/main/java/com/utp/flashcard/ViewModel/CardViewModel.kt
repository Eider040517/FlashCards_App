package com.utp.flashcard.ViewModel

import androidx.lifecycle.ViewModel
import com.utp.flashcard.database.entities.Card
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CardViewModel : ViewModel() {
    private val _cards = MutableStateFlow<List<Card>>(emptyList())
    val cards: StateFlow<List<Card>> get() = _cards

    fun addCard(card: Card) {
        _cards.update { currentCards -> currentCards + card }
    }

    fun updateCard(index: Int, card: Card) {
        _cards.update { currentCards ->
            currentCards.toMutableList().also { it[index] = card }
        }
    }
}