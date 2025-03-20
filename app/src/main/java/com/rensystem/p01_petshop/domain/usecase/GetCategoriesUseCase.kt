package com.rensystem.p01_petshop.domain.usecase

import com.rensystem.p01_petshop.domain.Repository
import com.rensystem.p01_petshop.domain.model.CategoryModel
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val repository: Repository) {
    suspend fun execute(): List<CategoryModel> {
        return repository.getCategories()
    }
}