package com.utp.flashcard.ui.comoponets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.utp.flashcard.R

@Composable
fun HeaderGameView() {
    Row (
        modifier =  Modifier.width(352.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        ArrowBack()
        TitleCardGame(title = "Verbos" )
        Spacer(Modifier.size(10.dp))
    }
}

@Composable
fun TitleCardGame(title :String ) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = colorResource(id = R.color.white)
    )
}

@Composable
fun ArrowBack() {
    Box {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                tint = colorResource(id = R.color.white),
                painter = painterResource(id = R.drawable.icon_arrow_back),
                contentDescription = "Icon arrow back",

            )
        }
    }
}


@Preview
@Composable

fun PreviewHeaderGameView() {
    HeaderGameView()
}