package com.rensystem.p01_petshop.data.model

import com.google.gson.annotations.SerializedName

data class PicListDataModel(
    @SerializedName("url") val url: String = ""
)
