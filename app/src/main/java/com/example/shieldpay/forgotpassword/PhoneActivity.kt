package com.example.shieldpay.forgotpassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.shieldpay.Data
import com.example.shieldpay.databinding.ActivityPhoneBinding
import com.example.shieldpay.onboarding.dismissKeyboard
import com.example.shieldpay.onboarding.setStatusBarColorWhite

class PhoneActivity : AppCompatActivity(), View.OnClickListener {

    // Variables
    private lateinit var binding: ActivityPhoneBinding

    // Overridden Method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.click = this
        setUpSpinner()
        window.apply {
            setStatusBarColorWhite()
        }
        binding.baselayout.apply {
            dismissKeyboard(this)
        }
    }

    // Class Method: For setting up spinner with adapter
    private fun setUpSpinner() {
        binding.customSpinner.adapter = CountryAdapter(this, Data.spinnerData(context = this))
    }

    // Overridden OnClick Method
    override fun onClick(p0: View?) {
        when(p0?.id) {
            binding.btnSendCode.id -> startActivity(Intent(this, VerifyAccountActivity::class.java))
        }
    }

}