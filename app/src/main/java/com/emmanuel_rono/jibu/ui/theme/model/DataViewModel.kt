package com.emmanuel_rono.jibu.ui.theme.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emmanuel_rono.jibu.ui.theme.Repository.detailRepository

class DataViewModel(repository: detailRepository) : ViewModel(){
    val readAll=repository.readData

}
class DataViewModelFactory(private val repository: detailRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DataViewModel::class.java)) {
            return DataViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}