package com.rensystem.p01_petshop.data.model
import com.google.gson.annotations.SerializedName
import com.rensystem.p01_petshop.domain.model.ItemsModel

data class ItemsDataModel(
    val title: String = "",

    var description: String = "",

    var picUrl: ArrayList<String> = ArrayList(),

    var size: ArrayList<String> = ArrayList(),

    var price: Double = 0.0,

    var rating: Double = 0.0,

    var numberInCart: Int = 0,

    var sellerName: String = "",

    var sellerTell: Int = 0,

    var sellerPic: String = ""
)

