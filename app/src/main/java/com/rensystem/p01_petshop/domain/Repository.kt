package com.rensystem.p01_petshop.domain

import com.rensystem.p01_petshop.domain.model.CategoryModel
import com.rensystem.p01_petshop.domain.model.ItemsModel
import com.rensystem.p01_petshop.domain.model.SliderModel

interface Repository {
    suspend fun getBanners(): List<SliderModel>
    suspend fun getCategories(): List<CategoryModel>
    suspend fun getBestSellers(): List<ItemsModel>
}
