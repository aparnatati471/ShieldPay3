
package com.example.shieldpay.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shieldpay.Data
import com.example.shieldpay.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    // Variables
    private lateinit var binding: FragmentHomeBinding

    // Overridden Method
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        setUpCardDetails()
        return binding.root
    }

    // Class Method
    private fun setUpCardDetails() {
        val cardRecyclerView = binding.cards
        cardRecyclerView.adapter = CardAdapter(Data.cardData(this))
    }

}