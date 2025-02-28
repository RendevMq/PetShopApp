package com.rensystem.p01_petshop.Adapter.CartAdapter

import ManagmentCart
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rensystem.p01_petshop.Helper.ChangeNumberItemsListener
import com.rensystem.p01_petshop.Model.ItemsModel
import com.rensystem.p01_petshop.R

class CartAdapter(
    val listItemSelected: ArrayList<ItemsModel>,
    val context:Context,
    var changeNumberItemsListener: ChangeNumberItemsListener?=null
) : RecyclerView.Adapter<CartViewHolder>() {

    private val managmentCart = ManagmentCart(context)

    //Definimos el listener que sera llamado cuando un cambio ocurra en el carrito
    private val updateCartListener : (Int) -> Unit = {
        position ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_viewholder_cart, parent, false)
        return CartViewHolder(layout,updateCartListener)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = listItemSelected[position]
        holder.render(item,managmentCart,listItemSelected,changeNumberItemsListener)
    }

    override fun getItemCount(): Int = listItemSelected.size
}