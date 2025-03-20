package com.rensystem.p01_petshop.data.model
import com.google.gson.annotations.SerializedName
import com.rensystem.p01_petshop.domain.model.ItemsModel

data class ItemsDataModel(
    @SerializedName("title") val title: String = "",
    @SerializedName("description") var description: String = "",
    @SerializedName("picUrl") var picUrl: ArrayList<String> = ArrayList(),
    @SerializedName("size") var size: ArrayList<String> = ArrayList(),
    @SerializedName("price") var price: Double = 0.0,
    @SerializedName("rating") var rating: Double = 0.0,
    @SerializedName("numberInCart") var numberInCart: Int = 0,
    @SerializedName("sellerName") var sellerName: String = "",
    @SerializedName("sellerTell") var sellerTell: Int = 0,
    @SerializedName("sellerPic") var sellerPic: String = ""
)

