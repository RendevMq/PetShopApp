package com.rensystem.p01_petshop.Adapter.PicListAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rensystem.p01_petshop.Model.CategoryModel
import com.rensystem.p01_petshop.Model.PicListModel
import com.rensystem.p01_petshop.databinding.ItemViewholderPicListBinding

class PicListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemViewholderPicListBinding.bind(view)

    fun render(
        item: PicListModel,
        isSelected: Boolean
    ) {

        //Cargar la imagen en el IamgeView de la Lista
        Glide.with(binding.picList.context)
            .load(item.url)
            .into(binding.picList)

        //Cambiar el fondo cuando el elemento esta seleccionado
        if (isSelected) {
            binding.picLayout.setBackgroundResource(com.rensystem.p01_petshop.R.drawable.grey_bg_selected)
        } else {
            binding.picLayout.setBackgroundResource(com.rensystem.p01_petshop.R.drawable.grey_bg)

        }
    }
}