@file:OptIn(ExperimentalMaterial3Api::class)

package com.utp.flashcard.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.utp.flashcard.R
import com.utp.flashcard.ui.comoponets.NewCard

@Composable
fun AddCardScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBar(navController) },
        bottomBar = { BottonBar(navController) },
        ) { innerPadding ->
        ConenteCards(innerPadding)
    }

}

@Composable
fun ConenteCards(innerPadding : PaddingValues){
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NewCard()
        NewCard()
    }
}


@Composable
fun TopBar(navController: NavController) {
    val  title = "Pregunta"
    TopAppBar(
        modifier = Modifier.padding(start = 10.dp),
        colors = topAppBarColors(
            containerColor = colorResource(id = R.color.background_app_ligth),
            titleContentColor = colorResource(id = R.color.black),
        ),
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_arrow_back),
                    contentDescription = "Icon Arrow back"
                )
            }
        },
        title = {
            Text(text = title)
        },


    )
}



@Composable
fun BottonBar(navController: NavController) {

    BottomAppBar(
        containerColor = colorResource(id = R.color.background_app_ligth),
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ) {

            ButtonGame(navController)
        }
    }
}

@Composable
fun ButtonGame(navController: NavController) {
    Button(
        onClick = {
                 navController.navigate("game")
        },
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