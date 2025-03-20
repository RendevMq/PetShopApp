package com.rensystem.p01_petshop.domain.usecase

import com.rensystem.p01_petshop.domain.Repository
import com.rensystem.p01_petshop.domain.model.SliderModel
import javax.inject.Inject

class GetBannersUseCase @Inject constructor (private val repository: Repository) {
    suspend fun execute(): List<SliderModel> {
        return repository.getBanners()
    }
}
