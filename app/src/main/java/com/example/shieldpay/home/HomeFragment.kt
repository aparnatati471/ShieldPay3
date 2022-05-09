
package com.example.shieldpay.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shieldpay.Data
import com.example.shieldpay.databinding.FragmentHomeBinding
import com.example.shieldpay.notification.NotificationActivity

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        setUpCardDetails()
        binding.imgNotification.setOnClickListener {
            startActivity(Intent(context, NotificationActivity::class.java))
        }
        return binding.root
    }

    private fun setUpCardDetails() {
        val cardRecyclerView = binding.cards
        cardRecyclerView.adapter = CardAdapter(Data.cardData(this))
    }

}