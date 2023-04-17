package com.example.samplechatapplication.activity

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.samplechatapplication.R
import com.example.samplechatapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val navController = findNavController(R.id.navHostFragment)
            if (navController.currentDestination?.id == R.id.home ||
                navController.currentDestination?.id == R.id.talk ||
                navController.currentDestination?.id == R.id.news) {
                finish()
            } else {
                navController.popBackStack()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.navHostFragment)
        // bottomNavigationViewとNavigationを紐付ける
        setupWithNavController(binding.bottomNavigation, navController)

        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        // 画面によってbottomNavigationViewの表示・非表示切り替え
        /*navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.friendSearch -> {
                    binding.bottomNavigation.visibility = View.GONE
                }
                else -> {
                    binding.bottomNavigation.visibility = View.VISIBLE
                }
            }
        }*/
    }

    // タブ切り替え処理
    fun moveTalkTab() {
        binding.bottomNavigation.selectedItemId = R.id.navigation_talk
    }
}