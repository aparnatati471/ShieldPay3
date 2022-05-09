package com.example.shieldpay.notification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shieldpay.Data
import com.example.shieldpay.R
import com.example.shieldpay.databinding.ActivityNotificationBinding
import com.example.shieldpay.home.BottomNavigationActivity
import com.example.shieldpay.onboarding.getColorDrawable
import com.example.shieldpay.onboarding.setStatusBarColorWhite
import com.google.android.material.tabs.TabLayoutMediator

class NotificationActivity : AppCompatActivity() {

    // Variables
    private lateinit var binding: ActivityNotificationBinding

    // Overridden Method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Data.setToolBar(this, binding.toolbarTitle, binding.toolbar, getString(R.string.notification))
        window.apply {
            setStatusBarColorWhite()
        }
        setUpFragments()
        binding.toolbar.setNavigationOnClickListener {
            startActivity(Intent(this, BottomNavigationActivity::class.java))
        }
    }

    // Class Method
    private fun setUpFragments() {
        binding.vpNotification.adapter = NotificationAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.tblNotification, binding.vpNotification) { tab, pos ->
            tab.text = NotificationAdapter.title[pos]
        }.attach()
    }

}