package com.uca.tareaextra_german_santos.Components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
// Esta función se encarga de mostrar un título con un estilo de fuente y tamaño de fuente específicos
fun TitleComp(title: String) {
    Text(
        text = title,
        style = TextStyle(
            fontSize = 24.sp, // Tamaño de fuente de 24sp
            color = Color.Black, // Color de texto negro
            fontWeight = FontWeight.Bold // Negrita
        ),
        modifier = Modifier.padding(vertical = 8.dp) // Espacio vertical de 8dp
    )
}
