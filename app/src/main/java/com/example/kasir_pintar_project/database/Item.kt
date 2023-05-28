package com.example.kasir_pintar_project.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class Item(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String?,
    val price: String?,
    val stock: Int?,
    val info: String?,
)
