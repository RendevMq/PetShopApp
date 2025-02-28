package com.rensystem.p01_petshop.Adapter.BestSellerAdapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rensystem.p01_petshop.Activity.DetailActivity
import com.rensystem.p01_petshop.Model.ItemsModel
import com.rensystem.p01_petshop.R

class BestSellerAdapter(val items: List<ItemsModel>) :
    RecyclerView.Adapter<BestSellerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_viewholder_bestseller, parent, false)
        return  BestSellerViewHolder(layout)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        val item = items[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = items.size
}