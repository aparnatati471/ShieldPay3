package com.example.shieldpay.forgotpassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.example.shieldpay.R
import com.example.shieldpay.databinding.ActivityVerifyAccountBinding
import com.example.shieldpay.onboarding.bold
import com.example.shieldpay.onboarding.color
import com.example.shieldpay.onboarding.dismissKeyboard
import com.example.shieldpay.onboarding.getStringFromRes
import com.example.shieldpay.onboarding.setStatusBarColorWhite

class VerifyAccountActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityVerifyAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.click = this
        binding.edtCodeOne.requestFocus()
        setUpCodeInputs()
        setUpStyle()
        window.apply {
            setStatusBarColorWhite()
        }
        binding.baselayout.apply {
            dismissKeyboard(this)
        }
    }

    // Class Method
    private fun setUpCodeInputs() {
        checkInput(binding.edtCodeOne, binding.edtCodeTwo)
        checkInput(binding.edtCodeTwo, binding.edtCodeThree)
        checkInput(binding.edtCodeThree, binding.edtCodeFour)
    }

    // Class Method: For changing focus of edittext
    private fun checkInput(edtCurrent: EditText, edtNext: EditText) {
        edtCurrent.doOnTextChanged { text, _, _, _ ->
            if(text?.isNotEmpty() == true) {
                edtNext.requestFocus()
            }
        }
    }

    // Class Method: For Setting up text style
    private fun setUpStyle() {
        val resendCode = SpannableString(binding.tvResendCode.text).apply {
            bold(0, length)
        }
        binding.tvResendCode.text = resendCode

        val firstString = SpannableString(getStringFromRes(R.string.enter_4_digit_code_we_have_sent)).apply {
            color("#333333", 0, this.length)
        }
        val secondString = SpannableString(getStringFromRes(R.string.number)).apply {
            color("#100D40", 0, this.length)
            bold(0, this.length)
        }
        binding.tvInfo.text = SpannableString(TextUtils.concat(firstString, " ", secondString))
    }

    // Overridden onClick Method
    override fun onClick(p0: View?) {
        when(p0?.id) {
            binding.btnVerifyNow.id -> startActivity(Intent(this, AccountCreatedActivity::class.java))
        }
    }

}