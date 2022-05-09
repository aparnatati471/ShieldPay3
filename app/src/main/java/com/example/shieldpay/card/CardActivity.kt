package com.example.shieldpay.card

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shieldpay.Data
import com.example.shieldpay.R
import com.example.shieldpay.databinding.ActivityCardBinding
import com.example.shieldpay.home.BottomNavigationActivity
import com.example.shieldpay.home.CardAdapter
import com.example.shieldpay.onboarding.setStatusBarColorWhite

class CardActivity : AppCompatActivity() {

    // Variables
    private lateinit var binding: ActivityCardBinding

    // Overridden Method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardBinding.inflate(layoutInflater)
        Data.setToolBar(this, binding.toolbarTitle, binding.toolbar, getString(R.string.your_cards))
        window.apply {
            setStatusBarColorWhite()
        }
        binding.toolbar.setNavigationOnClickListener {
            startActivity(Intent(this, BottomNavigationActivity::class.java))
        }
        setUpCards()
        setContentView(binding.root)
    }

    // Class Method
    private fun setUpCards() {
        binding.rvCards.adapter = CardAdapter(Data.cardDataTwo(this))
    }

}