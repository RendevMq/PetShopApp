package com.rensystem.p01_petshop.Adapter.PicListAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rensystem.p01_petshop.Model.PicListModel
import com.rensystem.p01_petshop.R

class PicListAdapter(
    private val items: MutableList<PicListModel>,
    private val picMain: ImageView
) :
    RecyclerView.Adapter<PicListViewHolder>() {

    private var selectedPosition = -1 // Para saber qué elemento está seleccionado

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicListViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_viewholder_pic_list, parent, false)
        return PicListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PicListViewHolder, position: Int) {
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

            // 📌 ACTUALIZAR IMAGEN PRINCIPAL
            Glide.with(picMain.context)
                .load(item.url)
                .into(picMain)
        }
    }

    override fun getItemCount(): Int = items.size
}