package com.example.second_module

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavAction
import androidx.navigation.NavController
import com.example.register_module.RegisterPageApi

@Composable
fun SecondPage(navActions: SecondPageSubgraphApi) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        var text by remember { mutableStateOf("") }
        Column() {
            TextField(value = text, onValueChange ={ text = it })
            TextButton(onClick = {
                navActions.goToTextPage("text")
            }) {
                Text(text = "Accept")
            }
        }
    }
}