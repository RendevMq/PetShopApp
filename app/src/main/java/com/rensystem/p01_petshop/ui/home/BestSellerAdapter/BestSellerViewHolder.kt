package com.rensystem.p01_petshop.ui.home.BestSellerAdapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.rensystem.p01_petshop.ui.detailProduct.DetailActivity
import com.rensystem.p01_petshop.domain.model.ItemsModel
import com.rensystem.p01_petshop.databinding.ItemViewholderBestsellerBinding

class BestSellerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemViewholderBestsellerBinding.bind(view)

    fun render(item: ItemsModel) {
        binding.titleTxt.text = item.title
        binding.priceTxt.text = "$" + item.price.toString()
        binding.ratingTxt.text = item.rating.toString()

        val requestOption = RequestOptions().transform(CenterCrop())

        Glide.with(binding.titleTxt.context)
            .load(item.picUrl[0])
            .apply(requestOption)
            .into(binding.picBestSeller)

        binding.root.setOnClickListener {
            val intent = Intent(binding.root.context, DetailActivity::class.java)
            intent.putExtra("object" , item)
            binding.root.context.startActivity(intent)
        }
    }

}