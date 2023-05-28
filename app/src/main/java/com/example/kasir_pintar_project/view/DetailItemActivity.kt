package com.example.kasir_pintar_project.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.kasir_pintar_project.R
import com.example.kasir_pintar_project.database.ItemDatabase
import com.example.kasir_pintar_project.database.ItemRepo
import com.example.kasir_pintar_project.databinding.ActivityDetailItemBinding
import com.example.kasir_pintar_project.databinding.ActivityMenuBinding
import com.example.kasir_pintar_project.factory.DetailViewModelFactory
import com.example.kasir_pintar_project.factory.MenuViewModelFactory
import com.example.kasir_pintar_project.model.ItemData
import com.example.kasir_pintar_project.util.IntentNameExtra
import com.example.kasir_pintar_project.util.KotlinExt.parcelable
import com.example.kasir_pintar_project.viewmodel.DetailViewModel
import com.example.kasir_pintar_project.viewmodel.MenuViewModel

class DetailItemActivity : AppCompatActivity() {
    private var _binding: ActivityDetailItemBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailViewModel by lazy {
        ViewModelProvider(
            this,
            DetailViewModelFactory(ItemRepo(ItemDatabase.getDatabase(this)))
        )[DetailViewModel::class.java]
    }

    private val itemData: ItemData by lazy {
        intent.parcelable(IntentNameExtra.MENU_EXTRA) ?: ItemData()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_item)

        itemData?.let { itemData ->
            viewModel.item = itemData
            Glide.with(this).load(itemData.picture).into(binding.ivItemDetail)

        }
        binding.viewModel = viewModel
    }
}