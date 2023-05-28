package com.example.kasir_pintar_project.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kasir_pintar_project.database.ItemRepo
import com.example.kasir_pintar_project.viewmodel.DetailViewModel
import com.example.kasir_pintar_project.viewmodel.MenuViewModel

class DetailViewModelFactory(private val repository: ItemRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailViewModel(repository) as T
        }
        throw IllegalArgumentException("UNKNOWN VIEW MODEL CLASS")
    }
}