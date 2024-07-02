package com.utp.flashcard.ui.comoponets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.utp.flashcard.R

@Composable
fun HeaderGameView(navController: NavController) {
    Row (
        modifier =  Modifier.width(352.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        ArrowBack(navController)
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
        color = colorResource(id = R.color.color_font_white)
    )
}

@Composable
fun ArrowBack(navController: NavController) {
    Box {
        IconButton(onClick = {navController.popBackStack()}) {
            Icon(
                tint = colorResource(id = R.color.color_font_white),
                painter = painterResource(id = R.drawable.icon_arrow_back),
                contentDescription = "Icon arrow back",

            )
        }
    }
}


