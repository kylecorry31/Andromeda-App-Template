package com.kylecorry.andromeda_template.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kylecorry.andromeda.core.tryOrNothing
import com.kylecorry.andromeda.fragments.AndromedaActivity
import com.kylecorry.andromeda_template.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AndromedaActivity() {

    private lateinit var bottomNavigation: BottomNavigationView

    private val permissions = mutableListOf<String>()

    private val navigation = MyNavController(supportFragmentManager, R.id.fragment_holder)

    override fun onCreate(savedInstanceState: Bundle?) {
        ExceptionHandler.initialize(this)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initializeNavigation()

        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation.setupWithMyNavController(navigation, mapOf(
            "main" to R.id.action_main,
            "settings" to R.id.action_settings
        ), R.id.action_main)

        requestPermissions(permissions) {
            navigation.navigateTo("main", resetBackStack = true)
        }
    }

    private fun initializeNavigation(){
        navigation.addRoute<MainFragment>("main")
        navigation.addRoute<SettingsFragment>("settings")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent ?: return
        setIntent(intent)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
//        bottomNavigation.selectedItemId = savedInstanceState.getInt(
//            "page",
//            R.id.action_main
//        )
//        if (savedInstanceState.containsKey("navigation")) {
//            tryOrNothing {
//                val bundle = savedInstanceState.getBundle("navigation_arguments")
//                val route = savedInstanceState.getString("navigation")
//                route?.let {
//                    navigation.navigateTo(it, bundle, resetBackStack = true)
//                }
//            }
//        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        outState.putInt("page", bottomNavigation.selectedItemId)
//        navigation.currentArguments?.let {
//            outState.putBundle("navigation_arguments", it)
//        }
//        navigation.currentRoute?.let {
//            outState.putString("navigation", it)
//        }
    }

}
