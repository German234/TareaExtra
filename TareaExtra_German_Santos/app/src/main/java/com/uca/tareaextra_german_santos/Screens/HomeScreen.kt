package com.uca.tareaextra_german_santos.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.uca.tareaextra_german_santos.Components.TaskList
import com.uca.tareaextra_german_santos.Components.TitleComp

@Composable
// Esta función se encarga de mostrar la pantalla principal de la aplicación donde esta la lista de tareas
fun HomeScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TitleComp(title = "Task List")
        TaskList()
    }
}