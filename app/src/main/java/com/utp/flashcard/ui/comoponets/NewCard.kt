@file:OptIn(ExperimentalMaterial3Api::class)

package com.utp.flashcard.ui.comoponets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.utp.flashcard.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewCard() {
    ElevatedCard(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .size(width = 330.dp, height = 260.dp)
            .background(color = colorResource(id = R.color.background_app_ligth)),
    ) {

        Text(
            text = stringResource(id = R.string.pregunta_card),
            color = colorResource(id = R.color.font_color_grey),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            TextCarde()
        }

    }
}


@Composable
fun TextCarde() {
    var input by rememberSaveable { mutableStateOf("") }

    TextField(
        value = input,
        onValueChange = { input = it },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray),
    )
}


@Preview
@Composable
fun PreviewNewCard() {
    NewCard()
}

