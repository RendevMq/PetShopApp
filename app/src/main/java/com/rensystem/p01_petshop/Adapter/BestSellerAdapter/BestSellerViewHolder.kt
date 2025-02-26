package com.rensystem.p01_petshop.Adapter.BestSellerAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.rensystem.p01_petshop.Model.ItemsModel
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
    }

}