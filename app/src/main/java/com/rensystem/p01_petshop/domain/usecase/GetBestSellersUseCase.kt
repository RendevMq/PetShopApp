package com.rensystem.p01_petshop.domain.usecase

import com.rensystem.p01_petshop.domain.Repository
import com.rensystem.p01_petshop.domain.model.ItemsModel
import javax.inject.Inject

class GetBestSellersUseCase @Inject constructor(private val repository: Repository) {
    suspend fun execute(): List<ItemsModel> {
        return repository.getBestSellers()
    }
}