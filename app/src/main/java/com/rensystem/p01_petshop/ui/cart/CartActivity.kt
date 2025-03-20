package com.rensystem.p01_petshop.ui.cart

import ManagmentCart
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rensystem.p01_petshop.ui.cart.CartAdapter.CartAdapter
import com.rensystem.p01_petshop.di.Helper.ChangeNumberItemsListener
import com.rensystem.p01_petshop.databinding.ActivityCartBinding
import com.rensystem.p01_petshop.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartActivity : BaseActivity() {

    private lateinit var binding: ActivityCartBinding
    private lateinit var managmentCart: ManagmentCart
    private var tax: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmentCart = ManagmentCart(this)

        setVariable()
        initCartList()

        calculateCart()//calcular el precio inicial al inciar la actividad
    }

    private fun calculateCart(){
        val percentTax = 0.02
        val delivery = 15.0
        tax = Math.round((managmentCart.getTotalFee()*percentTax)*100)/100.0
        val total = Math.round((managmentCart.getTotalFee()+tax+delivery)*100)/100
        val itemTotal = Math.round(managmentCart.getTotalFee()*100)/100

        with(binding){
            tvTotalFee.text = "$$itemTotal"
            tvTax.text = "$$tax"
            tvDelivery.text = "$$delivery"
            tvTotal.text = "$$total"
        }
    }

    private fun initCartList() {
        binding.viewCart.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.viewCart.adapter= CartAdapter(managmentCart.getListCart(),this, object :
            ChangeNumberItemsListener {
            override fun onChanged() {
                calculateCart()
            }
        })
    }

    private fun setVariable() {
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}