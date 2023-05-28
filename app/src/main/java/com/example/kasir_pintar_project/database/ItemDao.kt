package com.example.kasir_pintar_project.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ItemDao {
    @Query ("SELECT * FROM item ORDER BY id DESC")
    fun getItems(): LiveData<List<Item>>
}