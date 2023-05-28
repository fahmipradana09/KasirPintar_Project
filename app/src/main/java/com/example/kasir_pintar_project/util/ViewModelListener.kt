package com.example.kasir_pintar_project.util

interface ViewModelListener {
    fun showMessage(message: String?, isLong: Boolean = false)
    fun navigateTo(param: String)

}