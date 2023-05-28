package com.example.kasir_pintar_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kasir_pintar_project.database.Item
import com.example.kasir_pintar_project.databinding.ItemMenuBinding
import com.example.kasir_pintar_project.model.ItemData
import com.example.kasir_pintar_project.util.KotlinExt.openDetailActivity

class AdapterMenu(private val context: Context) :
    RecyclerView.Adapter<AdapterMenu.MenuViewHolder>() {
    private val items: ArrayList<Item> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder =
        MenuViewHolder(
            ItemMenuBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = items[position]
        holder.binding.item = item

        holder.binding.cardItem.setOnClickListener {
            it.context?.openDetailActivity(ItemData(item))
        }
    }

    override fun getItemCount() = items.size
    class MenuViewHolder(val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root)

    fun setData(list: List<Item>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

}