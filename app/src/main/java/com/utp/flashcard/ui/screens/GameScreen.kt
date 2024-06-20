package com.utp.flashcard.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.utp.flashcard.R

@Composable
fun GameScreen(){
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.background_game))
            .fillMaxSize()
    )  {

    }
}


@Preview
@Composable

fun PreviewSreceenGame(){
    GameScreen()
}

