package com.rensystem.p01_petshop.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.*
import com.rensystem.p01_petshop.Model.SliderModel

// MainViewModel maneja la lógica de obtención de banners desde Firebase
class MainViewModel : ViewModel() {

    // Se obtiene una instancia de la base de datos de Firebase
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    // Se usa MutableLiveData para poder actualizar la lista de banners en tiempo real
    private val _banner = MutableLiveData<List<SliderModel>>()

    // Se expone un LiveData de solo lectura para que MainActivity lo observe
    val banners: LiveData<List<SliderModel>> = _banner

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
}
