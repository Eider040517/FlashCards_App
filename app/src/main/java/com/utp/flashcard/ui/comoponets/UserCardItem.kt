package com.utp.flashcard.ui.comoponets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.utp.flashcard.R

@Composable
fun Card(){
    ElevatedCard(
        colors = CardDefaults.elevatedCardColors(
            containerColor = colorResource(id = R.color.background_app_ligth),
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp

        ),
        modifier = Modifier
            .size(width = 352.dp, height = 70.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Row (
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(45.dp)
                            .background(colorResource(id = R.color.yellow_background)),

                        ){
                        Icon(
                            modifier = Modifier
                                .size(37.dp)
                                .align(Alignment.Center) ,
                            painter = painterResource(id = R.drawable.icon_cards),
                            contentDescription = "IconCard",
                            tint = colorResource(id = R.color.yellow_tint)
                        )

                    }

                    Text(
                        modifier = Modifier
                            .padding(start = 10.dp),
                        text = "Titulo de la carta",
                        textAlign = TextAlign.Center,
                        fontSize = 19.sp
                    )
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier
                            .size(100.dp),
                        painter = painterResource(
                            id = R.drawable.icon_arrow_down),
                        contentDescription = "Icon Arrow",
                    )
                }
            }

        }


    }
}

@Preview
@Composable

fun PreviewCard(){
    Card()
}
