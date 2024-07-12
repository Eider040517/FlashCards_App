
package com.utp.flashcard.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.utp.flashcard.database.entities.Card
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    private val _cards = MutableStateFlow<List<Card>>(emptyList())
    val cards: StateFlow<List<Card>> get() = _cards

    private val _currentCardIndex = MutableStateFlow(0)
    val currentCardIndex: StateFlow<Int> get() = _currentCardIndex


    private val _removedCardCount = MutableStateFlow(0)
    val removedCardCount: StateFlow<Int> get() = _removedCardCount

    init {
        // Configurar una lista de cartas de ejemplo al iniciar el ViewModel
        //setExampleCards()
    }

    fun setCards(cards: List<Card>) {
        _cards.value = cards
        _currentCardIndex.value = 0
        Log.d("GameViewModel", "Cards set: ${cards.map { it.id }}")
    }

    private fun setExampleCards() {
        val exampleCards = listOf(
            Card(
                "¿Qué es un verbo?",
                "Un verbo es una palabra que indica acción, estado o proceso.",
                1,
                "2024-07-11"
            ),
            Card(
                "¿Cuál es la capital de Francia?",
                "La capital de Francia es París.",
                1,
                "2024-07-11"
            ),
            Card(
                "¿Quién escribió 'Don Quijote de la Mancha'?",
                "Miguel de Cervantes escribió 'Don Quijote de la Mancha'.",
                1,
                "2024-07-11"
            ),
            Card(
                "¿Cuál es el planeta más grande del sistema solar?",
                "El planeta más grande del sistema solar es Júpiter.",
                1,
                "2024-07-11"
            ),
            Card(
                "¿Qué es la fotosíntesis?",
                "La fotosíntesis es el proceso por el cual las plantas producen su alimento a partir de la luz solar.",
                1,
                "2024-07-11"
            )
        )
        _cards.value = exampleCards
    }

    fun nextCard() {
        _currentCardIndex.update { currentIndex ->
            if (currentIndex < _cards.value.size - 1) currentIndex + 1 else 0
        }
    }

    fun previousCard() {
        _currentCardIndex.update { currentIndex ->
            if (currentIndex > 0) currentIndex - 1 else _cards.value.size - 1
        }
    }

    fun removeCurrentCard() {
        val currentIndex = _currentCardIndex.value
        _cards.update { currentCards ->
            currentCards.toMutableList().also {
                it.removeAt(currentIndex)
            }
        }
        _removedCardCount.update { it + 1 }
        _currentCardIndex.update { currentIndex ->
            if (currentIndex > 0) currentIndex - 1 else 0
        }
    }

    fun getProgress(): Float {
        val totalCards = _cards.value.size + _removedCardCount.value
        return if (totalCards > 0) {
            _removedCardCount.value / totalCards.toFloat()
        } else {
            1f
        }
    }
}