package com.example.kasir_pintar_project.viewmodel

import com.example.kasir_pintar_project.database.ItemRepo
import com.example.kasir_pintar_project.util.ObservableViewModel

class MenuViewModel(
    private val repository: ItemRepo
) : ObservableViewModel() {
    fun getData() = repository.getData()
}