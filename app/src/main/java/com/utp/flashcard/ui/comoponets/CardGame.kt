package com.utp.flashcard.ui.comoponets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.utp.flashcard.R

@Composable
fun CardGameView(
) {

    ElevatedCard(
        modifier = Modifier
            .width(352.dp)
            .height(600.dp)
            .background(colorResource(id = R.color.white)),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            HeaderCardGame()
            TextCard("¿Que es un verbo?")
            ButtonArea()
        }
    }


}


@Composable
fun HeaderCardGame() {
    Row(
        modifier = Modifier
            .padding(top = 20.dp, start = 20.dp)

    ) {
        Text(
            text = stringResource(id = R.string.pregunta_card),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = colorResource(id = R.color.font_color_grey)
        )
    }
}

@Composable
fun TextCard(text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black)
        )

    }
}

@Composable

fun ButtonArea() {

    val backgroundColorBTN =
        ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.background_btn_game))
    val buttonModifier = Modifier
        .size(width = 160.dp, height = 50.dp)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    )
    {
        Button(
            onClick = { /*TODO*/ },
            modifier = buttonModifier,
            colors = backgroundColorBTN

        ) {
            Text(
                text = stringResource(id = R.string.text_btn_NO_game),
                color = colorResource(id = R.color.font_color_BTN_NO)
            )
        }

        Button(
            onClick = { /*TODO*/ },
            modifier = buttonModifier,
            colors = backgroundColorBTN
        ) {
            Text(
                text = stringResource(id = R.string.text_btn_YES_game),
                color = colorResource(id = R.color.font_color_BTN_YES)
            )
        }
    }
}

@Preview
@Composable

fun PreviewHeaderCardGame() {
    CardGameView()
}