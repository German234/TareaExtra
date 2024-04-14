package com.uca.tareaextra_german_santos.Components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Esta función se encarga de mostrar un dialogo de error en caso de que este vacio el contenido
fun EmptyErrorDialog(
    onConfirmation: () -> Unit,
    onDismissRequest: () -> Unit,
    dialogTitle: String,
) {
        AlertDialog(
            title = {
                Text(text = dialogTitle)
            },
            onDismissRequest = {
                onDismissRequest()
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onConfirmation()
                    }
                ) {
                    Text("Accept")
                }
            },
            )
    }