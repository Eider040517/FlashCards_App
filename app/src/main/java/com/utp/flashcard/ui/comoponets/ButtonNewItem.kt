package com.utp.flashcard.ui.comoponets

import android.graphics.Paint.Align
import android.text.Layout
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.utp.flashcard.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ButtonNewItem(navController: NavController){
    ElevatedCard(
        onClick = {
                 //Ejemplo se uso se tiene que cambiar el funciona namiento
                  navController.navigate("addCard")
        },
        colors = CardDefaults.elevatedCardColors(
            containerColor = colorResource(id = R.color.background_app_ligth)),
        modifier = Modifier
            .size(width = 352.dp, height = 70.dp),
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = "Nuevo",
                textAlign = TextAlign.Center,
                fontSize = 19.sp
            )
        }

    }
}
