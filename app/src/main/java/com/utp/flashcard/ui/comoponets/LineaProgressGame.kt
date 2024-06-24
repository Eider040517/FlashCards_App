package com.utp.flashcard.ui.comoponets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.utp.flashcard.R

@Composable
fun LineaProgressGame() {
    LinearProgress()
}

@Composable
fun LinearProgress() {
    Column {
        LinearProgressIndicator(
            progress = 0.1f,
            modifier = Modifier
                .width(352.dp)
                .height(10.dp),
            color = colorResource(id = R.color.color_linearProgress),
            trackColor = colorResource(id = R.color.background_linearProgress)
        )
    }
}

@Preview
@Composable

fun PreviewLineaProgressGame() {
    LineaProgressGame()
}