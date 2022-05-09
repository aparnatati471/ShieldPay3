package com.example.shieldpay.forgotpassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shieldpay.databinding.ActivityForgotPasswordBinding
import com.example.shieldpay.onboarding.dismissKeyboard
import com.example.shieldpay.onboarding.setStatusBarColorWhite

class ForgotPasswordActivity : AppCompatActivity() {

    // Variables
    private lateinit var binding: ActivityForgotPasswordBinding

    // Overridden Method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.apply {
            setStatusBarColorWhite()
        }
        binding.baselayout.apply {
            dismissKeyboard(this)
        }
    }

}