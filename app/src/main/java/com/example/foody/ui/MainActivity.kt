package com.example.foody.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foody.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    // NavController mengelola navigasi aplikasi dalam NavHost.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.navHostFragment)
        // findNavController Metode ini akan menemukan NavController yang terkait dengan tampilan ini
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                    R.id.recipesFragment,
                    R.id.favoriteRecipesFragment,
                    R.id.foodJokeFragment
            )
        )

        bottomNavigationView.setupWithNavController(navController)
        // setupWithNavController digunakan untuk menghubungkan toolbar dengan NavController
        setupActionBarWithNavController(navController, appBarConfiguration)
        // setupActionBarWithNavController digunakan untuk mengelola ikon panel samping navigasi dan toolbar
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}