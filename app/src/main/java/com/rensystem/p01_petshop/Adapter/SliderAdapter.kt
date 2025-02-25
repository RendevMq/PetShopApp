package com.rensystem.p01_petshop.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.viewpager2.widget.ViewPager2
import com.rensystem.p01_petshop.Model.SliderModel
import com.rensystem.p01_petshop.R

class SliderAdapter(
    private var sliderItems: List<SliderModel>,
    private val viewPage2: ViewPager2

) : RecyclerView.Adapter<SliderViewHolder>() {

    private lateinit var context: Context
    private val runnable = Runnable {
        sliderItems = sliderItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.slider_image_container, parent, false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.setImage(sliderItems[position],context)
        if (position == sliderItems.lastIndex - 1){
            viewPage2.post(runnable)
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}