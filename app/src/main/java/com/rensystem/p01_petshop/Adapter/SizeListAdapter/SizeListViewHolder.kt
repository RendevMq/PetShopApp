package com.rensystem.p01_petshop.Adapter.SizeListAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rensystem.p01_petshop.R
import com.rensystem.p01_petshop.databinding.ItemViewholderSizeBinding

class SizeListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemViewholderSizeBinding.bind(view)

    fun render(
        item: String,
        isSelected: Boolean
    ) {

        binding.sizeeTxt.text = item
        val context = binding.sizeLayout.context

        //Cambiar el fondo cuando el elemento esta seleccionado
        if (isSelected) {
            binding.sizeLayout.setBackgroundResource(com.rensystem.p01_petshop.R.drawable.green_bg3)
            binding.sizeeTxt.setTextColor(context.resources.getColor(R.color.white))
        } else {
            binding.sizeLayout.setBackgroundResource(com.rensystem.p01_petshop.R.drawable.grey_bg)
            binding.sizeeTxt.setTextColor(context.resources.getColor(R.color.black))
        }


    }


}