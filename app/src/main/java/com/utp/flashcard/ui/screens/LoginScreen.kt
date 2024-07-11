package com.utp.flashcard.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.utp.flashcard.R
import com.utp.flashcard.ViewModel.LoginViewModel


@Composable
fun LoginScreen(navController: NavController) {

    val viewModel : LoginViewModel = viewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.color_font_white)),
        verticalArrangement = Arrangement.Center,
    ) {
        FormLogin(navController, viewModel)
    }
}

@Composable
fun FormLogin(navController: NavController,viewModel: LoginViewModel) {

    val name by viewModel.name.collectAsState()
    val nickName by viewModel.nickName.collectAsState()
    val loggedInUserId by viewModel.loggedInUserId.collectAsState()

    LaunchedEffect(loggedInUserId) {
        loggedInUserId?.let { userId ->
            navController.navigate("home/$userId")
        }
    }

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
                UserTextField(name , onValueChange = { viewModel.updateName(it)})
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
                PasswordTextField(nickName, onValueChange = { viewModel.updateNickName(it)})
            }
            ButtonSign{viewModel.loginUser()}
        }


    }
}

@Composable
fun UserTextField( name: String, onValueChange : (String) -> Unit) {
    OutlinedTextField(
        value = name,
        onValueChange = onValueChange,
        Modifier
            .width(360.dp)
            .height(60.dp),
    )
}

@Composable
fun PasswordTextField(nickName: String, onValueChange : (String) -> Unit) {

    OutlinedTextField(
        value = nickName,
        onValueChange = onValueChange,
        Modifier
            .width(360.dp)
            .height(60.dp),
        visualTransformation = PasswordVisualTransformation(),
    )
}

@Composable
fun ButtonSign(onClick : () -> Unit) {
    Button(
        modifier = Modifier
            .width(360.dp)
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.black)),
        onClick = onClick
    ) {
        Text(
            text = "Iniciar Secion",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }

}

