package com.rensystem.p01_petshop.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.*
import com.rensystem.p01_petshop.domain.model.CategoryModel
import com.rensystem.p01_petshop.domain.model.ItemsModel
import com.rensystem.p01_petshop.domain.model.SliderModel
import com.rensystem.p01_petshop.domain.usecase.GetBannersUseCase
import com.rensystem.p01_petshop.domain.usecase.GetBestSellersUseCase
import com.rensystem.p01_petshop.domain.usecase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// MainViewModel maneja la lógica de obtención de banners desde Firebase
/*
class MainViewModel : ViewModel() {

    // Se obtiene una instancia de la base de datos de Firebase
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    // Se usa MutableLiveData para poder actualizar la lista de banners en tiempo real
    private val _banner = MutableLiveData<List<SliderModel>>()
    private val _category = MutableLiveData<MutableList<CategoryModel>>()
    private val _bestSeller = MutableStateFlow<List<ItemsModel>>(emptyList())

    // Se expone un LiveData de solo lectura para que MainActivity lo observe
    val banners: LiveData<List<SliderModel>> = _banner
    val category: LiveData<MutableList<CategoryModel>> = _category
    val bestSeller: StateFlow<List<ItemsModel>> = _bestSeller

    // Metodo que obtiene los banners desde Firebase
    fun loadBanners() {
        // Se obtiene la referencia a la ubicación "Banner" en Firebase
        val ref = firebaseDatabase.getReference("Banner")

        // Se añade un listener para escuchar cambios en la base de datos
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<SliderModel>()

                // Se recorre cada hijo del snapshot recibido de Firebase
                for (childSnapshot in snapshot.children) {
                    // Convierte cada nodo en un objeto SliderModel
                    val list = childSnapshot.getValue(SliderModel::class.java)

                    // Si el objeto no es nulo, se agrega a la lista
                    if (list != null) {
                        lists.add(list)
                    }
                }

                // Se actualiza el LiveData, notificando a MainActivity automáticamente
                _banner.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                // Manejo de errores en caso de fallo en la conexión a Firebase
            }
        })
    }

    fun loadCategory() {
        val ref = firebaseDatabase.getReference("Category")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val lists = mutableListOf<CategoryModel>()

                // Se recorre cada hijo del snapshot recibido de Firebase
                for (childSnapshot in snapshot.children) {
                    // Convierte cada nodo en un objeto SliderModel
                    val list = childSnapshot.getValue(CategoryModel::class.java)
                    // Si el objeto no es nulo, se agrega a la lista
                    if (list != null) {
                        lists.add(list)
                    }
                }

                _category.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    fun loadBestSeller() {
        val ref = firebaseDatabase.getReference("Items")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<ItemsModel>()

                // Se recorre cada hijo del snapshot recibido de Firebase
                for (childSnapshot in snapshot.children) {
                    // Convierte cada nodo en un objeto SliderModel
                    val list = childSnapshot.getValue(ItemsModel::class.java)
                    // Si el objeto no es nulo, se agrega a la lista
                    if (list != null) {
                        lists.add(list)
                    }
                }
                // Emitimos los nuevos valores usando StateFlow
                viewModelScope.launch(Dispatchers.IO) { //Se usa IO para que la consulta a Firebase no bloquee el hilo principal.
                    _bestSeller.emit(lists) //Actualiza el estado con la nueva lista de datos.
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}*/

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getBannersUseCase: GetBannersUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getBestSellersUseCase: GetBestSellersUseCase
) : ViewModel() {

    private val _banner = MutableLiveData<List<SliderModel>>()
    private val _category = MutableLiveData<List<CategoryModel>>()
    //private val _bestSeller = MutableStateFlow<List<ItemsModel>>(emptyList())
    private val _bestSeller =MutableLiveData<List<ItemsModel>>()

    val banners: LiveData<List<SliderModel>> = _banner
    val category: LiveData<List<CategoryModel>> = _category
    //val bestSeller: StateFlow<List<ItemsModel>> = _bestSeller
    val bestSeller: LiveData<List<ItemsModel>> = _bestSeller
    // Función para cargar banners
    fun loadBanners() {
        viewModelScope.launch {
            val bannersList = getBannersUseCase.execute()
            Log.d("MainViewModel", "Banners cargados: ${bannersList.size} banners")  // Log después de cargar los banners
            _banner.value = bannersList
        }
    }

    // Función para cargar categorías
    fun loadCategory() {
        viewModelScope.launch {
            val categoryList = getCategoriesUseCase.execute()
            Log.d("MainViewModel", "Categorías cargadas: ${categoryList.size} categorías")  // Log después de cargar las categorías
            _category.value = categoryList
        }
    }

    // Función para cargar productos más vendidos
    fun loadBestSeller() {
        viewModelScope.launch {
            val items = getBestSellersUseCase.execute()
            Log.d("MainViewModel", "Best Sellers cargados: ${items.size} productos")  // Log después de cargar los best sellers
            _bestSeller.value = items
        }
    }
}