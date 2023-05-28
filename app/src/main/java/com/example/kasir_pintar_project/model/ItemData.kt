package com.example.kasir_pintar_project.model

import android.os.Parcelable
import com.example.kasir_pintar_project.database.Item
import com.example.kasir_pintar_project.util.KotlinExt.orZero
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemData(
    val id: String = "",
    val name: String? = "",
    val price: Int? = 0,
    val stock: Int? = 0,
    val info: String? = "",
    val picture: String? = ""
) : Parcelable {
    constructor(item: Item) : this(item.id, item.name, item.price, item.stock, item.info,item.picture)

    fun getStockInString() ="$stock item"
    fun getPriceInString() ="Rp $price"
    fun imageExists() = picture?.isNotBlank()
}