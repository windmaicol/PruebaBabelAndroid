package com.example.pruebababelandroid.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.example.pruebababelandroid.R
import com.example.pruebababelandroid.databinding.ActivityMainBinding
import com.example.pruebababelandroid.ui.fragment.CharacterFragment
import com.example.pruebababelandroid.ui.fragment.EpisodesFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Clase principal que contiene la logica de los fragments
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigationBottom()
        val fragment = EpisodesFragment.newInstance()
        openFragment(fragment)
    }
    /**
     * metodo configuración del menu inferior
     */
    private fun initNavigationBottom() {
        binding.botNavView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_episode -> {
                    val fragment = EpisodesFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.action_character -> {
                    val fragment = CharacterFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }
    }
    /**
     * metodo para abrir los fragmentos
     */
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}