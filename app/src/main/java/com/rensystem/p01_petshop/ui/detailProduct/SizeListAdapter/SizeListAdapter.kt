package com.rensystem.p01_petshop.ui.detailProduct.SizeListAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rensystem.p01_petshop.R

class SizeListAdapter (private val items: MutableList<String>) :
    RecyclerView.Adapter<SizeListViewHolder>() {
    private var selectedPosition = -1 // Para saber qué elemento está seleccionado

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeListViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_viewholder_size, parent, false)
        return SizeListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: SizeListViewHolder, position: Int) {
        val item = items[position]

        //Pasamos la informacion al ViewHolder
        holder.render(item, selectedPosition == position)

        //Manejo del clic para seleccionar el elemnto
        holder.itemView.setOnClickListener {
            val currentPosition = holder.adapterPosition
            if (currentPosition == RecyclerView.NO_POSITION) return@setOnClickListener // Verifica si la posición es válida, cancela el clic si la posición no es válida.

            val lastSelectedPosition = selectedPosition
            selectedPosition = position //Actualiza la posicion seleccionada

            //Notificar cambios para actualizar solo las posiciones afectadas
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }
    }

    override fun getItemCount(): Int = items.size
}