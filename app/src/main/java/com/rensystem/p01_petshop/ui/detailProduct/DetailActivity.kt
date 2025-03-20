package com.rensystem.p01_petshop.ui.detailProduct

import ManagmentCart
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.rensystem.p01_petshop.ui.detailProduct.PicListAdapter.PicListAdapter
import com.rensystem.p01_petshop.ui.detailProduct.SizeListAdapter.SizeListAdapter
import com.rensystem.p01_petshop.domain.model.ItemsModel
import com.rensystem.p01_petshop.domain.model.PicListModel
import com.rensystem.p01_petshop.databinding.ActivityDetailBinding
import com.rensystem.p01_petshop.ui.BaseActivity
import com.rensystem.p01_petshop.ui.cart.CartActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var item: ItemsModel
    private var numbeOrder = 1
    private lateinit var managmentCart: ManagmentCart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmentCart = ManagmentCart(this)

        getBundle()

        initList()
    }

    private fun getBundle() {
        // Obtenemos el objeto Parcelable
        item = intent.getParcelableExtra<ItemsModel>("object")!!

        binding.titleTxt.text = item.title
        binding.descriptionTxt.text = item.description
        binding.priceTxt.text = "$" + item.price
        binding.ratinggTxt.text = "${item.rating} Rating"
        binding.sellerNameTxt.text = item.sellerName

        // Botón para agregar al carrito
        binding.btnAddToCart.setOnClickListener {
            item.numberInCart = numbeOrder
            managmentCart.insertItem(item)
        }
        // Botón para regresar
        binding.btnBack.setOnClickListener { finish() }

        //Cargar la imagen del vendedor
        Glide.with(this)
            .load(item.sellerPic)
            .apply(RequestOptions().transform(CircleCrop()))
            .into(binding.picSeller)

        //Botón para enviar mensaje al vendedor
        binding.btnMsgToSeller.setOnClickListener {
            val sendIntent = Intent(Intent.ACTION_VIEW)
            sendIntent.setData(Uri.parse("sms: " + item.sellerTell))
            sendIntent.putExtra("sms_body", "type your message")
            startActivity(sendIntent)
        }

        //Botón para llamar al vendedor
        binding.btnCallToSeller.setOnClickListener {
            val phone = item.sellerTell.toString()
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            startActivity(intent)
        }

        //Boton icono ir carrito
        binding.cartBtn.setOnClickListener{
            startActivity(Intent(this@DetailActivity , CartActivity::class.java))
        }

    }


    private fun initList() {
        val sizeList = ArrayList<String>()
        for (size in item.size) {
            sizeList.add(size.toString())
        }
        binding.viewSizeList.adapter = SizeListAdapter(sizeList)
        binding.viewSizeList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val picList = ArrayList<PicListModel>()
        for (imageUrl in item.picUrl){
            picList.add(PicListModel(imageUrl))
        }

        Glide.with(this)
            .load(picList[0].url)
            .into(binding.viewPicMain)

        binding.viewPicList.adapter = PicListAdapter(picList,binding.viewPicMain)
        binding.viewPicList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }
}