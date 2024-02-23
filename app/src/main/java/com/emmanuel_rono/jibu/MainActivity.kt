package com.emmanuel_rono.jibu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.emmanuel_rono.jibu.ui.theme.JibuTheme
import com.emmanuel_rono.jibu.ui.theme.Repository.detailRepository
import com.emmanuel_rono.jibu.ui.theme.model.DataViewModel
import com.emmanuel_rono.jibu.ui.theme.model.DataViewModelFactory
import com.emmanuel_rono.jibu.ui.theme.model.PersonDao
import com.emmanuel_rono.jibu.ui.theme.model.personDatabase
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JibuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray
                ) {
                    val personDao = personDatabase.getDatabase(applicationContext).userDao()
                    val repository = detailRepository(detailDao = personDao)
                    val viewModelFactory = DataViewModelFactory(repository)
                    val viewModel: DataViewModel by viewModels { viewModelFactory }

                    val dataState by viewModel.readAll.collectAsState(initial = null)
                    dataState?.let { data ->
                        LazyColumn(
                            contentPadding = PaddingValues(all = 12.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(data) { person ->
                                // Display each person item in the LazyColumn
                                Text(
                                    text = "Name: ${person.firstName} ${person.lastName}, Age: ${person.age}",
                                    style = TextStyle(fontSize = 16.sp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


