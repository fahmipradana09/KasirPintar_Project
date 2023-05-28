package com.example.kasir_pintar_project.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kasir_pintar_project.R
import com.example.kasir_pintar_project.adapter.AdapterMenu
import com.example.kasir_pintar_project.database.ItemDatabase
import com.example.kasir_pintar_project.database.ItemRepo
import com.example.kasir_pintar_project.databinding.ActivityMenuBinding
import com.example.kasir_pintar_project.factory.MenuViewModelFactory
import com.example.kasir_pintar_project.viewmodel.MenuViewModel

class MenuActivity : AppCompatActivity() {
    private var _binding: ActivityMenuBinding? = null
    private val binding get() = _binding!!

    private val adapterMenu: AdapterMenu by lazy {
        AdapterMenu(this)
    }

    private val viewModel: MenuViewModel by lazy {
        ViewModelProvider(
            this,
            MenuViewModelFactory(ItemRepo(ItemDatabase.getDatabase(this)))
        )[MenuViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_menu)

        binding.listItem.adapter = adapterMenu
        binding.listItem.layoutManager = LinearLayoutManager(this)

        viewModel.getData().observe(this) { item ->
            adapterMenu.setData(item)
        }
    }
}