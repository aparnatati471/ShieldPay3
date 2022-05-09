package com.example.shieldpay.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shieldpay.Data
import com.example.shieldpay.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpCardDetails()
    }

    private fun setUpCardDetails() {
        val cardRecyclerView = binding.cards
        //cardRecyclerView.adapter = CardAdapter(Data.cardData(this))
    }
}