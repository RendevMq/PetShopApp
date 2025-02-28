package com.rensystem.p01_petshop.Adapter.CartAdapter

import ManagmentCart
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.rensystem.p01_petshop.Helper.ChangeNumberItemsListener
import com.rensystem.p01_petshop.Model.ItemsModel
import com.rensystem.p01_petshop.databinding.ItemViewholderCartBinding

class CartViewHolder(view: View, private val updateCartListener: (Int) -> Unit) :
    RecyclerView.ViewHolder(view) {

    val binding = ItemViewholderCartBinding.bind(view)
    private val context = itemView.context  // Contexto de la vista

    fun render(
        item: ItemsModel,
        managmentCart: ManagmentCart,
        listItemSelected: ArrayList<ItemsModel>,
        changeNumberItemsListener: ChangeNumberItemsListener?
    ) {
        binding.txtTitle.text = item.title
        binding.txtFeeRachItem.text = "$-${item.price}"
        binding.txtTotalEachItem.text = "$${Math.round(item.numberInCart * item.price)}"
        binding.tvNumberItem.text = item.numberInCart.toString()

        Glide.with(binding.root.context)
            .load(item.picUrl[0])
            .apply(RequestOptions().transform(CenterCrop()))
            .into(binding.picCart)

// Manejar el botón para incrementar la cantidad
        binding.plusCartBtn.setOnClickListener {
            managmentCart.plusItem(
                listItemSelected,
                adapterPosition,
                object : ChangeNumberItemsListener {
                    override fun onChanged() {
                        updateCartListener(adapterPosition)// Llamar al listener para notificar el cambio
                        changeNumberItemsListener?.onChanged()
                    }
                })
        }

        // Manejar el botón para disminuir la cantidad
        binding.minusCartBtn.setOnClickListener {
            managmentCart.minusItem(
                listItemSelected,
                adapterPosition,
                object : ChangeNumberItemsListener {
                    override fun onChanged() {
                        updateCartListener(adapterPosition) // Llamar al listener para notificar el cambio
                        changeNumberItemsListener?.onChanged()
                    }
                })
        }
    }
}