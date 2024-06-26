package com.utp.flashcard.ui.comoponets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.utp.flashcard.R

@Composable
fun BottonBarHome(){
   Row (
      modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight()
          .background(colorResource(id = R.color.background_app_ligth)),
       horizontalArrangement = Arrangement.SpaceAround,
       verticalAlignment = Alignment.CenterVertically
   ) {

       IconButton(onClick = {}){
           Icon(
               painter = painterResource(id = R.drawable.icon_user),
               contentDescription = "User Icon" )
       }

       IconButton(onClick = { /*TODO*/ }) {
           Icon(
               painter = painterResource(id = R.drawable.icon_stack),
               contentDescription = "Icon Stack")
       }
   } 
}

@Preview
@Composable
fun PreviewBottonBarHome(){
   BottonBarHome() 
}