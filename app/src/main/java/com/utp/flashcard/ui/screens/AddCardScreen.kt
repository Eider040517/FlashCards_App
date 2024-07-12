@file:OptIn(ExperimentalMaterial3Api::class)

package com.utp.flashcard.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.utp.flashcard.ViewModel.ShareViewModel
import com.utp.flashcard.database.entities.Card
import com.utp.flashcard.ui.comoponets.NewCard
import java.util.Date

@Composable
fun AddCardScreen(navController: NavController,viewModel: ShareViewModel, packId: Int) {
    val cards by viewModel.cards.collectAsState()

    Scaffold(
        topBar = { TopBar(navController) },
        bottomBar = { BottonBar(navController) },
        floatingActionButton = {
            ButtonAddCard {
                val currentDate = Date().toString()
                val newCard = Card("Nueva pregunta", "Nueva respuesta", packId, currentDate)
                viewModel.addCard(newCard)
            }
        }
    ) { innerPadding ->
        Column(
            Modifier.padding(innerPadding)
        ) {
            LazyRow(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(start = 30.dp, end = 30.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(cards) { card ->
                    ConenteCard(card, viewModel)
                }
            }
            Text("Current cards: $cards")
        }

    }

}

@Composable
fun ConenteCard(card: Card, shareViewModel: ShareViewModel) {
    var questionText by rememberSaveable { mutableStateOf(card.question) }
    var answerText by rememberSaveable { mutableStateOf(card.answer) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NewCard("Pregunta", questionText) { newQuestion ->
            questionText = newQuestion
            shareViewModel.updateCard(
                card.id,
                Card(questionText, card.answer, card.id_pack, card.created_at)
            )
        }

        NewCard("Respuesta", answerText) { newAnswer ->
            answerText = newAnswer
            shareViewModel.updateCard(
                card.id,
                Card(card.question, answerText, card.id_pack, card.created_at)
            )
        }
    }
}

@Composable
fun ButtonAddCard(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController) {
    val title = "Pregunta"
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