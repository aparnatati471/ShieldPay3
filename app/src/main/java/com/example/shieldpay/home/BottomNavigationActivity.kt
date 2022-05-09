package com.example.shieldpay.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.shieldpay.R
import com.example.shieldpay.databinding.ActivityBottomNavigationBinding

class BottomNavigationActivity : AppCompatActivity() {

    // Variables
    private lateinit var binding: ActivityBottomNavigationBinding

    // Overridden Method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        binding.bottomNavBar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.bottom_nav_home -> replaceFragment(HomeFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_cotainer, fragment)
        transaction.commit()
    }

}