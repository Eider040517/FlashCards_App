package com.utp.flashcard.ui.screens

import androidx.compose.foundation.background
import com.utp.flashcard.ui.comoponets.BottonBarHome
import com.utp.flashcard.ui.comoponets.ButtonNewItem
import com.utp.flashcard.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.utp.flashcard.ViewModel.HomeViewModel
import com.utp.flashcard.database.entities.Pack
import com.utp.flashcard.ui.comoponets.Card


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController , userID : Int) {

    val homeViewModel: HomeViewModel = viewModel()

    Scaffold(topBar = {
        TopAppBar(modifier = Modifier.padding(20.dp), colors = topAppBarColors(
            containerColor = colorResource(R.color.background_app_ligth),
            titleContentColor = colorResource(R.color.black)
        ), title = { TitleHeader(userID) })
    }, bottomBar = {
        BottomAppBar(
            containerColor = colorResource(id = R.color.background_app_ligth),
        ) {
            BottonBarHome()
        }
    }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),

            ) {

            BodyContent(homeViewModel, navController)
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyContent(viewModel: HomeViewModel, navController: NavController) {

    val packs by viewModel.pack.collectAsState()
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ButtonNewItem { showBottomSheet = !showBottomSheet }

        LazyColumn {
            items(packs) { pack ->
                Card(pack) { navController.navigate("addCard/123") } // Composable personalizado para mostrar cada pack
            }
        }

    }

    if (showBottomSheet) {

        ModalBottomSheet(
            modifier = Modifier.height(500.dp),
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            ContentModalBotton( showModalBottonSheet ={ showBottomSheet = !showBottomSheet }, viewModel =  viewModel)
        }
    }

}


@Composable
fun ContentModalBotton(showModalBottonSheet: () -> Unit, viewModel: HomeViewModel) {

    var titlePack by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        Box(
            modifier = Modifier.run {
                clip(CircleShape)
                    .size(80.dp)
                    .background(colorResource(R.color.yellow_background))
            },

            ) {
            Icon(
                modifier = Modifier
                    .size(75.dp)
                    .align(Alignment.Center),
                painter = painterResource(R.drawable.icon_cards),
                contentDescription = "IconCard",
                tint = colorResource(id = R.color.yellow_tint)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
        ) {
            Text(
                text = stringResource(id = R.string.title),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )

            OutlinedTextField(
                modifier = Modifier
                    .width(350.dp)
                    .height(70.dp),
                value = titlePack,
                onValueChange = { titlePack = it }
            )

            Button(
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp),
                onClick = {
                    viewModel.addNewCar(Pack(titlePack, 1,"00000"))
                    showModalBottonSheet()
                }) {
                Text(
                    text = stringResource(id = R.string.crear),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = colorResource(
                        id = R.color.color_font_white
                    )
                )
            }
        }


    }
}

@Composable
fun TitleHeader(userID: Int) {
    Text(text = userID.toString(), fontSize = 35.sp)
}
