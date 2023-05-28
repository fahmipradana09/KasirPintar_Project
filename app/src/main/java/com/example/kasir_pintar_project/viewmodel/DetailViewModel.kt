package com.example.kasir_pintar_project.viewmodel

import androidx.databinding.Bindable
import com.example.kasir_pintar_project.database.ItemRepo
import com.example.kasir_pintar_project.model.ItemData
import com.example.kasir_pintar_project.util.ObservableViewModel
import com.example.kasir_pintar_project.BR

class DetailViewModel(
    private val repository: ItemRepo
) : ObservableViewModel() {
    @Bindable
    var item = ItemData()
        set(value) {
            field = value
            notifyPropertyChanged(BR.item)
        }
}