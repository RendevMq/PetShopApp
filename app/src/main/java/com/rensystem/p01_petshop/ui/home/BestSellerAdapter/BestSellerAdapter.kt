package com.rensystem.p01_petshop.ui.home.BestSellerAdapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rensystem.p01_petshop.domain.model.ItemsModel
import com.rensystem.p01_petshop.R

class BestSellerAdapter(val items: List<ItemsModel>) :
    RecyclerView.Adapter<BestSellerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_viewholder_bestseller, parent, false)
        return  BestSellerViewHolder(layout)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        // Verifica si la posición está dentro de los límites de la lista
        if (position < items.size) {
            val item = items[position]
            holder.render(item)
        } else {
            Log.e("BestSellerAdapter", "Intento de acceder a un índice fuera de los límites: $position")
        }
    }


    override fun getItemCount(): Int = items.size
}