package com.example.kasir_pintar_project.util

import android.content.Context
import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable
import com.example.kasir_pintar_project.model.ItemData
import com.example.kasir_pintar_project.util.IntentNameExtra.MENU_EXTRA
import com.example.kasir_pintar_project.view.DetailItemActivity

object KotlinExt {
    fun Context.openDetailActivity(itemData: ItemData) {
        Intent(this, DetailItemActivity::class.java).run {
            putExtra(MENU_EXTRA, itemData)
            startActivity(this)
        }
    }

    fun Int?.orZero() = this ?: 0

    inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
        SDK_INT >= 33 -> getParcelableExtra(key, T::class.java)
        else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
    }

    inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
        SDK_INT >= 33 -> getParcelable(key, T::class.java)
        else -> @Suppress("DEPRECATION") getParcelable(key) as? T
    }
}