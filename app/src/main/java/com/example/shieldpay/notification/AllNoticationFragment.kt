package com.example.shieldpay.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shieldpay.Data
import com.example.shieldpay.databinding.FragmentAllNoticationBinding

class AllNoticationFragment : Fragment() {

    // Variables
    private lateinit var binding: FragmentAllNoticationBinding

    // Overridden Method
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllNoticationBinding.inflate(layoutInflater)
        setUpNotification()
        return binding.root
    }

    // Class Method
    private fun setUpNotification() {
        binding.rvNotification.adapter =UnreadNotificationAdapter(Data.allNotificationData(this))
    }

}