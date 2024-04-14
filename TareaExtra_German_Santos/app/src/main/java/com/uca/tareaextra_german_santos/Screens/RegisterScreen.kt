package com.uca.tareaextra_german_santos.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.uca.tareaextra_german_santos.Components.EmptyErrorDialog
import com.uca.tareaextra_german_santos.Components.TitleComp

@Composable
//Esta vista se encarga de mostrar la pantalla de registro de la aplicación
fun Register(navController: NavHostController){
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    var showErrorBlank = remember { mutableStateOf(false) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        TitleComp(title ="Register")
        Column(
            modifier = Modifier
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = name.value,
                onValueChange = { name.value = it },
                placeholder = { Text(text = "Enter name") }
            )

            OutlinedTextField(
                modifier = Modifier.padding(top = 16.dp),
                value = email.value,
                onValueChange = { email.value = it },
                placeholder = { Text(text = "Enter a email") }
            )
            if(showErrorBlank.value){
                EmptyErrorDialog(
                    onConfirmation = { showErrorBlank.value = false},
                    onDismissRequest = { showErrorBlank.value = false},
                    dialogTitle = "You can't leave the fields blank",
                )
            }
        }
        Button(
            onClick = {
                if(name.value.isNotBlank() && email.value.isNotBlank()){
            navController.navigate("Home")
        }else{
            showErrorBlank.value = true
        }
            }) {
            Text(text = "Send")
        }

    }

}