@file:OptIn(ExperimentalMaterial3Api::class)

package com.utp.flashcard.ui.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.utp.flashcard.R

@Preview
@Composable
fun AddCardScreen() {
    val title: String = "Sudoku"
    Scaffold(
        topBar = { TopBar(title) },
        bottomBar = { BottonBar() },

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
        }
    }

}

@Composable

fun TopBar(title: String) {
    TopAppBar(
        modifier = Modifier.padding(start = 10.dp),
        colors = topAppBarColors(
            containerColor = colorResource(id = R.color.background_app_ligth),
            titleContentColor = colorResource(id = R.color.black),
        ),
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_arrow_back),
                    contentDescription = "Icon Arrow back"
                )
            }
        }
    )
}

@Composable
fun BottonBar() {
    BottomAppBar(
        containerColor = colorResource(id = R.color.background_app_ligth),
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ) {

            ButtonGame()
        }
    }
}

@Composable
fun ButtonGame() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(width = 150.dp, height = 50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.font_color_BTN_YES))
    ) {
        Text(
            text = stringResource(id = R.string.jugar),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    }
}