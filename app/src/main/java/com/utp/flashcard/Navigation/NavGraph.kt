package com.utp.flashcard.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.utp.flashcard.ui.screens.AddCardScreen
import com.utp.flashcard.ui.screens.GameScreen
import com.utp.flashcard.ui.screens.HomeScreen
import com.utp.flashcard.ui.screens.LoginScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("addCard") {
            AddCardScreen(navController)
        }
        composable("game") {
            GameScreen(navController)
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
