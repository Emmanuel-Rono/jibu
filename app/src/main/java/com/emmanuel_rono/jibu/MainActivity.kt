package com.emmanuel_rono.jibu

import android.media.session.PlaybackState.CustomAction
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition.Companion.None
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
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
 import com.emmanuel_rono.jibu.ui.theme.JibuTheme
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.emmanuel_rono.jibu.ui.theme.Repository.detailRepository
import com.emmanuel_rono.jibu.ui.theme.View.CustomItem


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JibuTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   val detailRepository= detailRepository()
                   val getData= detailRepository.getAllData()
                    LazyColumn(
                        contentPadding = PaddingValues(all=12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    )
                    {
                       items  (items=getData){person -> CustomItem(person=person) }

                }
            }
        }
    }
}}





