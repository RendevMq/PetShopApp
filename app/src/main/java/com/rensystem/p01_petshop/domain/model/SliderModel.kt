package com.rensystem.p01_petshop.domain.model

import com.rensystem.p01_petshop.data.model.SliderDataModel

data class SliderModel(
    val url:String = ""
)

fun SliderDataModel.toDomain(): SliderModel {
    return SliderModel(
        url = this.url
    )
}