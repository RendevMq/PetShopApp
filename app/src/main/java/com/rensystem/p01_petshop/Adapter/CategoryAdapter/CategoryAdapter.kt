package com.rensystem.p01_petshop.Adapter.CategoryAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.rensystem.p01_petshop.Model.CategoryModel
import com.rensystem.p01_petshop.R
import com.rensystem.p01_petshop.databinding.ItemViewholderCategoryBinding

class CategoryAdapter(private val items: MutableList<CategoryModel>) :
    RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_viewholder_category, parent, false)
        return CategoryViewHolder(layout)
    }

    override fun onBindViewHolder(viewHolder: CategoryViewHolder, position: Int) {
        val item = items[position]
        return viewHolder.bind(item)
    }

    override fun getItemCount(): Int = items.size
}