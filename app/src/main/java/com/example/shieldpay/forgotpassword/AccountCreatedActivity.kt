package com.example.shieldpay.forgotpassword

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.TextUtils
import android.view.View
import com.example.shieldpay.R
import com.example.shieldpay.basesetup.BaseActivity
import com.example.shieldpay.databinding.ActivityAccountCreatedBinding
import com.example.shieldpay.onboarding.color
import com.example.shieldpay.onboarding.getStringFromRes
import com.example.shieldpay.onboarding.underline
import com.example.shieldpay.signin.SigninActivity
import com.example.shieldpay.webservices.http.AuthenticationViewModel

class AccountCreatedActivity : BaseActivity<ActivityAccountCreatedBinding, AuthenticationViewModel>(
    ActivityAccountCreatedBinding::inflate,
    AuthenticationViewModel::class.java
), View.OnClickListener {

    // Overridden Method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.click = this
        setUpStyle()
    }

    // Overridden Onclick Method
    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btnContinue.id -> startActivity(Intent(this, SigninActivity::class.java))
        }
    }

    // Class Method: For Setting up text style
    private fun setUpStyle() {
        val firstString = SpannableString(getStringFromRes(R.string.agree_terms)).apply {
            color("#100D40", 0, this.length)
        }
        val secondString = SpannableString(getStringFromRes(R.string.terms)).apply {
            color("#333333", 0, this.length)
            underline(0, this.length)
        }
        val text = SpannableString(TextUtils.concat(firstString, " ", secondString))
        binding.tvAgree.text = text
    }

}