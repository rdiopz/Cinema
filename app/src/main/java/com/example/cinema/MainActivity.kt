package com.example.cinema

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.cinema.helpers.SharedPreferencesHelper
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appSharedPreferencesHelper = SharedPreferencesHelper(this)
        if(!appSharedPreferencesHelper.getBooleanData("is_OnBoarding")) {
            val onBoardingActivity = Intent(this@MainActivity, OnBoarding::class.java)
            startActivity(onBoardingActivity)
        }
        val navHostFragment =  supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHostFragment.navController
        setupWithNavController(findViewById<BottomNavigationView>(R.id.bottomNavView), navController)
    }
}



