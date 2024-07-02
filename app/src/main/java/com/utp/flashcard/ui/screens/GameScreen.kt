package com.utp.flashcard.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.utp.flashcard.R
import com.utp.flashcard.ui.comoponets.CardGameView
import com.utp.flashcard.ui.comoponets.HeaderGameView
import com.utp.flashcard.ui.comoponets.LinearProgress

@Composable
fun GameScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.background_game))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))
        HeaderGameView(navController)
        Spacer(modifier = Modifier.height(20.dp))
        LinearProgress()
        Spacer(modifier = Modifier.height(20.dp))
        CardGameView()
    }
}


