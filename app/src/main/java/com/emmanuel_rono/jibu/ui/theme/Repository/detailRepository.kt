package com.emmanuel_rono.jibu.ui.theme.Repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emmanuel_rono.jibu.ui.theme.model.DataViewModel
import com.emmanuel_rono.jibu.ui.theme.model.Person
import com.emmanuel_rono.jibu.ui.theme.model.PersonDao

class detailRepository(private val detailDao: PersonDao)
{
    val readData=detailDao.readAllData()
    }
