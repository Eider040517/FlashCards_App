@file:OptIn(ExperimentalMaterial3Api::class)

package com.utp.flashcard.ui.screens

import com.utp.flashcard.ui.comoponets.Card
import com.utp.flashcard.ui.comoponets.BottonBarHome
import com.utp.flashcard.ui.comoponets.ButtonNewItem
import com.utp.flashcard.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Scaffold (
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(20.dp),
                colors = topAppBarColors(
                    containerColor = colorResource(R.color.background_app_ligth),
                    titleContentColor = colorResource(R.color.black)
                ),
                title = { TitleHeader() }
            )
        }, bottomBar = {
            BottomAppBar(
                containerColor = colorResource(id = R.color.background_app_ligth),
            ) {
                BottonBarHome()
            }
        }){innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),

        ) {

            BodyContent()
        }

    }
}


@Composable
fun BodyContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        ButtonNewItem()
        Card()
        Card()
        Card()
        Card()
        Card()
    }

}



@Composable
fun TitleHeader(){
    Text(
        text = "Mis cartas",
        fontSize = 35.sp
    )

}

@Preview
@Composable
fun GeetingPreview(){
    HomeScreen()
}