package com.rensystem.p01_petshop.ui.home.SliderAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.request.RequestOptions
import com.rensystem.p01_petshop.domain.model.SliderModel
import com.rensystem.p01_petshop.databinding.SliderImageContainerBinding

class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = SliderImageContainerBinding.bind(itemView)

    fun setImage(sliderItems: SliderModel) {

        val requestOptions = RequestOptions().transform(CenterInside())

        Glide.with(binding.imageSlide.context)
            .load(sliderItems.url)
            .apply(requestOptions)
            .into(binding.imageSlide)
    }

}