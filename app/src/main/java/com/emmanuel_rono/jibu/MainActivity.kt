package com.emmanuel_rono.jibu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.emmanuel_rono.jibu.ui.theme.JibuTheme
import androidx.compose.material.icons.Icons

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JibuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PasswordInput()
                }
            }
        }
    }
}


@Composable
fun PasswordInput() {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by rememberSaveable { mutableStateOf(false) }
    val icon =if (passwordVisibility) {
        painterResource(id = R.drawable.ic_baseline_visibility_24)
    }
    else {
        painterResource(id = R.drawable.ic_baseline_visibility_24)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = password,
            onValueChange = { newPassword ->
                password = newPassword
            },
            label = { Text("Password") }, // Optionally provide a label
            visualTransformation = PasswordVisualTransformation(), // Mask input as password
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ), // Set keyboard type to password
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                passwordVisibility =! passwordVisibility
                Icon(
                   painter = icon,
                    contentDescription = "vs Ion"
                )
            }
        }
    )
    }
}



