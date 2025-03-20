package com.rensystem.p01_petshop.data

import com.google.firebase.database.FirebaseDatabase
import com.rensystem.p01_petshop.data.model.CategoryDataModel
import com.rensystem.p01_petshop.data.model.ItemsDataModel
import com.rensystem.p01_petshop.data.model.SliderDataModel
import com.rensystem.p01_petshop.domain.Repository
import com.rensystem.p01_petshop.domain.model.CategoryModel
import com.rensystem.p01_petshop.domain.model.ItemsModel
import com.rensystem.p01_petshop.domain.model.SliderModel
import com.rensystem.p01_petshop.domain.model.toDomain
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseRepository @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase
): Repository {

    override suspend fun getBanners(): List<SliderModel> {
        val ref = firebaseDatabase.getReference("Banner")
        val snapshot = ref.get().await()
        val sliderDataList = snapshot.children.mapNotNull { it.getValue(SliderDataModel::class.java) }

        // Convertimos los modelos de datos a modelos de dominio
        return sliderDataList.map { it.toDomain() }
    }

    override suspend fun getCategories(): List<CategoryModel> {
        // Obtenemos los datos de Firebase
        val ref = firebaseDatabase.getReference("Category")
        val snapshot = ref.get().await() // Usamos await para hacer una llamada asincrónica sin bloquear el hilo principal
        val categoryDataList = snapshot.children.mapNotNull { it.getValue(CategoryDataModel::class.java) }

        // Convertimos los modelos de datos a modelos de dominio usando los mappers
        return categoryDataList.map { it.toDomain() }
    }

    override suspend fun getBestSellers(): List<ItemsModel> {
        val ref = firebaseDatabase.getReference("Items")
        val snapshot = ref.get().await()
        val itemDataList = snapshot.children.mapNotNull { it.getValue(ItemsDataModel::class.java) }

        // Convertimos los modelos de datos a modelos de dominio
        return itemDataList.map { it.toDomain() }
    }
}
