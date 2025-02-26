package com.rensystem.p01_petshop.Activity

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        // Ajustar padding solo si hay barra de navegación visible
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { view, insets ->
            val navBarHeight = getNavigationBarHeight()
            view.updatePadding(bottom = navBarHeight) // Ajusta el padding inferior correctamente
            insets
        }
    }

    // Método para obtener la altura real de la barra de navegación
    private fun getNavigationBarHeight(): Int {
        val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        return if (resourceId > 0) resources.getDimensionPixelSize(resourceId) else 0
    }
}
