package com.rensystem.p01_petshop.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.rensystem.p01_petshop.data.model.ItemsDataModel

data class ItemsModel(
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
) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.createStringArrayList() as ArrayList<String>,
        parcel.createStringArrayList() as ArrayList<String>,
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeStringList(picUrl)
        parcel.writeStringList(size)
        parcel.writeDouble(price)
        parcel.writeDouble(rating)
        parcel.writeInt(numberInCart)
        parcel.writeString(sellerName)
        parcel.writeInt(sellerTell)
        parcel.writeString(sellerPic)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemsModel> {
        override fun createFromParcel(parcel: Parcel): ItemsModel {
            return ItemsModel(parcel)
        }

        override fun newArray(size: Int): Array<ItemsModel?> {
            return arrayOfNulls(size)
        }
    }

}

fun ItemsDataModel.toDomain(): ItemsModel {
    return ItemsModel(
        title = this.title,
        description = this.description,
        picUrl = this.picUrl,
        size = this.size,
        price = this.price,
        rating = this.rating,
        numberInCart = this.numberInCart,
        sellerName = this.sellerName,
        sellerTell = this.sellerTell,
        sellerPic = this.sellerPic
    )
}
