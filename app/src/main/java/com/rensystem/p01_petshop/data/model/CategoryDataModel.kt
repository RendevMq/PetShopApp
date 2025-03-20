package com.rensystem.p01_petshop.data.model

import com.google.gson.annotations.SerializedName

data class CategoryDataModel(
    @SerializedName("titlePet")
    val title: String = "",

    val id: Int = 0,

    val picUrl: String = ""
)
