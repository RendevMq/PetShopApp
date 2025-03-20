package com.rensystem.p01_petshop.domain.model

import com.rensystem.p01_petshop.data.model.CategoryDataModel

data class CategoryModel(
    val title: String = "",
    val id: Int = 0,
    val picUrl: String = ""
)

//MAPPER
fun CategoryDataModel.toDomain(): CategoryModel {
    return CategoryModel(
        title = this.title,
        id = this.id,
        picUrl = this.picUrl
    )
}