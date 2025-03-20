package com.rensystem.p01_petshop.domain.model

import com.rensystem.p01_petshop.data.model.PicListDataModel

data class PicListModel(
    val url : String = ""
)

fun PicListDataModel.toDomain(): PicListModel {
    return PicListModel(
        url = this.url
    )
}