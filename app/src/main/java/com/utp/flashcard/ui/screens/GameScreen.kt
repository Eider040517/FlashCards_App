package com.utp.flashcard.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.utp.flashcard.R
import com.utp.flashcard.ViewModel.GameViewModel
import com.utp.flashcard.ViewModel.ShareViewModel
import com.utp.flashcard.ui.comoponets.CardGameView
import com.utp.flashcard.ui.comoponets.HeaderGameView
import com.utp.flashcard.ui.comoponets.LinearProgressGame

@Composable
fun GameScreen(navController: NavController, shareViewModel: ShareViewModel) {
    val gameViewModel: GameViewModel = viewModel()
    val cards by shareViewModel.cards.collectAsState()
    val progress by remember { derivedStateOf { gameViewModel.getProgress() } }

    LaunchedEffect(cards) {
        gameViewModel.setCards(cards)
    }

    val currentCardIndex by gameViewModel.currentCardIndex.collectAsState()
    val currentCards by gameViewModel.cards.collectAsState()

    var rotated by remember { mutableStateOf(false) }
    val rotar by animateFloatAsState(
        targetValue = if (rotated) 180f else 0f,
        animationSpec = tween(500)
    )

    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.background_game))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Spacer(modifier = Modifier.height(30.dp))
        HeaderGameView(navController)
        Spacer(modifier = Modifier.height(20.dp))
        LinearProgressGame(progress)
        Spacer(modifier = Modifier.height(20.dp))

        if (currentCards.isNotEmpty()) {
            val currentCard = currentCards[currentCardIndex]
            CardGameView(
                card = currentCard,
                onNext = { gameViewModel.nextCard() },
                onDelet = { gameViewModel.removeCurrentCard() },
                rotated = rotated,
                onRotate = { rotated = !rotated },
                rotar = rotar
            )

        } else {
            Text(text = "No cards available")
        }

    }
}


