package com.example.kasir_pintar_project.model

import android.os.Parcelable
import com.example.kasir_pintar_project.database.Item
import com.example.kasir_pintar_project.util.KotlinExt.orZero
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemData(
    val id: String = "",
    val name: String? = "",
    val price: String? = "",
    val stock: Int? = 0,
    val info: String? = "",
) : Parcelable {
    constructor(item: Item) : this(item.id, item.name, item.price, item.stock, item.info)

    fun getStockInString() = stock?.orZero().toString()

//    fun imageExists() = picture?.isNotBlank()
}