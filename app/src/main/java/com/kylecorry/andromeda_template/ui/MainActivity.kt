package com.kylecorry.andromeda_template.ui

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.kylecorry.andromeda.fragments.AndromedaActivity
import com.kylecorry.andromeda_template.R

class MainActivity : AndromedaActivity() {

    private lateinit var navController: NavController

    private val permissions = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        navController = findNavController()

        requestPermissions(permissions) {
            navController.navigate(R.id.action_main)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent ?: return
        setIntent(intent)
    }

    private fun findNavController(): NavController {
        return (supportFragmentManager.findFragmentById(R.id.fragment_holder) as NavHostFragment).navController
    }
}
