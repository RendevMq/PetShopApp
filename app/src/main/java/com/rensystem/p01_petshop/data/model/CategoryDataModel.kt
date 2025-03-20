package com.rensystem.p01_petshop.data.model

import com.google.gson.annotations.SerializedName

data class CategoryDataModel(
    @SerializedName("title") val title: String = "",
    @SerializedName("id") val id: Int = 0,
    @SerializedName("picUrl") val picUrl: String = ""
)
