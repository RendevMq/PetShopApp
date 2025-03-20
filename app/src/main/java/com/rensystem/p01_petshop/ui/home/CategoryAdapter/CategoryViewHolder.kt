package com.rensystem.p01_petshop.ui.home.CategoryAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rensystem.p01_petshop.domain.model.CategoryModel
import com.rensystem.p01_petshop.databinding.ItemViewholderCategoryBinding

class CategoryViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    private val binding = ItemViewholderCategoryBinding.bind(itemView)

    fun bind(item: CategoryModel) {
        binding.titleCat.text = item.title

        Glide.with(binding.picCat.context)
            .load(item.picUrl)
            .into(binding.picCat)
    }

}