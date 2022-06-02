
package com.example.shieldpay.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.shieldpay.Data
import com.example.shieldpay.basesetup.BaseFragment
import com.example.shieldpay.card.CardActivity
import com.example.shieldpay.databinding.FragmentHomeBinding
import com.example.shieldpay.notification.NotificationActivity
import com.example.shieldpay.webservices.http.AuthenticationViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, AuthenticationViewModel>(
    FragmentHomeBinding::inflate,
    AuthenticationViewModel::class.java
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpCardDetails()
        binding.tvViewAll.setOnClickListener {
            startActivity(Intent(context, CardActivity::class.java))
        }
        binding.imgNotification.setOnClickListener {
            startActivity(Intent(context, NotificationActivity::class.java))
        }
        binding.tvViewSavings.setOnClickListener {
            startActivity(Intent(context, com.example.shieldpay.notifications.NotificationActivity::class.java))
        }
    }

    private fun setUpCardDetails() {
        binding.cards.adapter = CardAdapter(Data.cardData(this))
    }

}