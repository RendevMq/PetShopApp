package com.rensystem.p01_petshop.ui.home.CategoryAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rensystem.p01_petshop.domain.model.CategoryModel
import com.rensystem.p01_petshop.R

class CategoryAdapter(private val items: List<CategoryModel>) :
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