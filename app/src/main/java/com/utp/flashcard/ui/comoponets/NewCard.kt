@file:OptIn(ExperimentalMaterial3Api::class)

package com.utp.flashcard.ui.comoponets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.utp.flashcard.R

@Composable
fun NewCard(type: String, inputText: String, onValueChange: (String) -> Unit) {
    var input by rememberSaveable { mutableStateOf(inputText) }
    ElevatedCard(
        modifier = Modifier
            .size(width = 330.dp, height = 260.dp)
            .background(color = colorResource(id = R.color.background_app_ligth)),
    ) {

        Text(
            text = type,
            color = colorResource(id = R.color.font_color_grey),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            BasicTextField(
                value = input,
                onValueChange = {
                    input = it
                    onValueChange(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray),
            )
        }
    }
}







