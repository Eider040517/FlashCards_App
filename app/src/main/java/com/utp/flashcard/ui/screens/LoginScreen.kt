package com.utp.flashcard.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.utp.flashcard.R


@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.color_font_white)),
        verticalArrangement = Arrangement.Center,
    ) {

        FormLogin(navController)
    }
}

@Composable
fun FormLogin(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.spacedBy(40.dp)
    )
    {
        //Content head Icon
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        )
        {
            Icon(
                modifier = Modifier
                    .size(80.dp)
                    .defaultMinSize(40.dp),
                painter = painterResource(id = R.drawable.icon_user),
                contentDescription = "Icon User"
            )

            Text(
                text = "Iniciar Seccion",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }

        //Content Forms login
        Column(
            verticalArrangement = Arrangement.spacedBy(35.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(
                    modifier = Modifier.width(360.dp),
                    text = "Usuario",
                    fontSize = 18.sp
                )
                UserTextField()
            }
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.width(360.dp),
                    text = "Contraseña",
                    fontSize = 18.sp
                )
                PasswordTextField()
            }
            ButtonSign(navController)
        }


    }
}

@Composable
fun UserTextField() {
    var input by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = input,
        onValueChange = { input = it },
        Modifier
            .width(360.dp)
            .height(60.dp),
    )
}

@Composable
fun PasswordTextField() {
    var password by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        Modifier
            .width(360.dp)
            .height(60.dp),
        visualTransformation = PasswordVisualTransformation(),
    )
}

@Composable
fun ButtonSign(navController: NavController) {
    Button(
        modifier = Modifier
            .width(360.dp)
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.black)),
        onClick = {
            navController.navigate("home")
        }
    ) {
        Text(
            text = "Iniciar Secion",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }

}

