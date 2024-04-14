package com.uca.tareaextra_german_santos.Components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.uca.tareaextra_german_santos.data.tasksList

@Composable
fun TaskList() {
    //Se crea una lista mutable de tareas utilizando Dummy Data
    val tasks = remember { tasksList }
    var showDialog by remember { mutableStateOf(false) }
    var showError by remember { mutableStateOf(false) }
    var completedTask by remember { mutableStateOf("") }
    val newTask: MutableState<String> = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        OutlinedTextField(
            value = newTask.value, onValueChange = { newTask.value = it },
            singleLine = true,
            placeholder = { Text(text = "Enter a task") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true
            )
        )
        Button(
            onClick = {
                if(newTask.value.isNotBlank()) {
                    tasks.add(newTask.value)
                    newTask.value = ""
                }else{
                    showError = true

                }
            }
        ) {
            Text(text = "Add")
        }
        Box{
            LazyColumn {
                items(tasks) { task ->
                    Row(
                        modifier = Modifier
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = task, modifier = Modifier.weight(1f))
                        Button(
                            onClick = {
                                completedTask = task
                                showDialog = true
                            },
                        ) {
                            Text(text = "Complete")
                        }
                    }
                }
            }
        }

    }


    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Task Completed") },
            text = { Text(text = "¿Did you complete the '$completedTask' task?") },
            confirmButton = {
                Button(
                    onClick = {
                        tasks.remove(completedTask)
                        showDialog = false
                    }
                ) {
                    Text(text = "Yes")
                }
            },
            dismissButton = {
                Button(
                    onClick = { showDialog = false }
                ) {
                    Text(text = "Not yet")
                }
            }
        )
    }
    if(showError){
        EmptyErrorDialog(
            onConfirmation = { showError = false},
            onDismissRequest = { showError = false},
            dialogTitle = "You can't add an empty task"
        )
    }
}
