package com.uca.tareaextra_german_santos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.uca.tareaextra_german_santos.Screens.HomeScreen
import com.uca.tareaextra_german_santos.navigation.MainNavigation
import com.uca.tareaextra_german_santos.ui.theme.TareaExtra_German_SantosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TareaExtra_German_SantosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Se maneja el estado de la navegacion de la app
                    val Navigation = rememberNavController()
                    MainNavigation(navController = Navigation)
                }
            }
        }
    }
}
