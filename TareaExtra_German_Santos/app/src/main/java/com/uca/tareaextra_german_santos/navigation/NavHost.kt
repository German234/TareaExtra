package com.uca.tareaextra_german_santos.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uca.tareaextra_german_santos.Screens.HomeScreen
import com.uca.tareaextra_german_santos.Screens.Register

@Composable
// Esta función se encarga de la navegación entre pantallas
fun MainNavigation(navController: NavHostController, modifier: Modifier = Modifier){
    NavHost(navController = navController, startDestination = "LoginScreen", modifier = modifier){
        composable("LoginScreen"){
            Register(navController)
        }
        composable("Home"){
            HomeScreen(navController)
        }
    }

}