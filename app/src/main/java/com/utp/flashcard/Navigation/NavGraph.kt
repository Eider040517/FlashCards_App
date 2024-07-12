package com.utp.flashcard.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.utp.flashcard.ViewModel.ShareViewModel
import com.utp.flashcard.ui.screens.AddCardScreen
import com.utp.flashcard.ui.screens.GameScreen
import com.utp.flashcard.ui.screens.HomeScreen
import com.utp.flashcard.ui.screens.LoginScreen

@Composable
fun NavGraph(navController: NavHostController) {
   val shareViewModel : ShareViewModel = viewModel()

    NavHost(navController = navController, startDestination = "login") {
        composable("addCard/{packId}") { backStackEntry ->
            val packId = backStackEntry.arguments?.getString("packId")?.toInt() ?: 0
            AddCardScreen(navController, shareViewModel,packId)
        }
        composable("game") {
            GameScreen(navController,shareViewModel)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("home/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")?.toInt() ?: 0
            HomeScreen(navController, userId)
        }
    }
}
