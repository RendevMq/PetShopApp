package com.rensystem.p01_petshop.Activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.rensystem.p01_petshop.Adapter.SliderAdapter
import com.rensystem.p01_petshop.Model.SliderModel
import com.rensystem.p01_petshop.ViewModel.MainViewModel
import com.rensystem.p01_petshop.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    // Se crea una instancia del ViewModel para obtener los banners desde Firebase
    private val viewModel = MainViewModel()

    // ViewBinding para acceder a los elementos de la UI
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Se infla el layout con ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Se inicializa el slider de banners
        initBanner()
    }

    // Metodo que maneja la carga de banners
    private fun initBanner() {
        // Muestra el ProgressBar mientras se cargan las imágenes
        binding.progressBarBanner.visibility = View.VISIBLE

        // Observa el LiveData de banners en el ViewModel
        viewModel.banners.observe(this) { bannersList ->
            banners(bannersList) // Llama a la función para configurar el slider
            binding.progressBarBanner.visibility = View.GONE // Oculta el ProgressBar
            Log.i("RenatooObserve", "Se actualizo la lista de banners")
        }

        // Se solicita la carga de banners desde Firebase
        viewModel.loadBanners()
    }

    // Metodo que configura el ViewPager2 para mostrar los banners
    private fun banners(images: List<SliderModel>) {
        // Configura el adaptador del ViewPager2 con las imágenes recibidas
        binding.viewPagerSlider.adapter = SliderAdapter(images)

        // Configuración para evitar que las imágenes sean recortadas
        binding.viewPagerSlider.clipToPadding = false
        binding.viewPagerSlider.clipChildren = false

        // Se establece un límite para precargar hasta 3 imágenes
        binding.viewPagerSlider.offscreenPageLimit = 3

        // Evita el efecto de rebote al desplazarse en el slider
        binding.viewPagerSlider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        // Agrega un efecto de transformación entre páginas
        val compositePageTransformer = CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(40)) // Agrega margen entre imágenes
        }
        binding.viewPagerSlider.setPageTransformer(compositePageTransformer)

        // Si hay más de una imagen, se muestra el indicador de paginación (puntos)
        if (images.size > 1) {
            binding.dotIndicator.visibility = View.VISIBLE
            binding.dotIndicator.attachTo(binding.viewPagerSlider)
        }
    }
}
