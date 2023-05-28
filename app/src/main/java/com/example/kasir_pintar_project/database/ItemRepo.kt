package com.example.kasir_pintar_project.database

import androidx.lifecycle.LiveData

class ItemRepo(private val database: ItemDatabase) {
    fun getData(): LiveData<List<Item>> = database.itemDao().getItems()
}