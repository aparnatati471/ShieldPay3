package com.example.shieldpay.signin

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.TextUtils
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.shieldpay.MainActivity
import com.example.shieldpay.R
import com.example.shieldpay.databinding.ActivitySigninBinding
import com.example.shieldpay.onboarding.bold
import com.example.shieldpay.onboarding.color
import com.example.shieldpay.onboarding.getStringFromRes
import com.example.shieldpay.onboarding.isValidEmail
import com.example.shieldpay.onboarding.isValidPassword
import com.example.shieldpay.onboarding.setStatusBarColorBlue
import com.example.shieldpay.onboarding.validate
import com.example.shieldpay.signup.SignupActivity

class SigninActivity : AppCompatActivity(), View.OnClickListener {

    // Variables
    private lateinit var binding: ActivitySigninBinding
    private var check = true

    // Overridden Method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.click = this
        val window = window.apply {
            setStatusBarColorBlue()
        }
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setUpTextViewStyle()
        dismissKeyboard()
    }

    // Class Method: For Validation
    private fun validation() {
        if (check) {
            binding.edtEmailAddress.validate(getString(R.string.email_validation)) { s -> s.isValidEmail() }
            binding.edtPass.validate(getString(R.string.password_validation)) { s -> s.isValidPassword() }
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
        check = false
    }

    // Class Method: Setting style of the text
    private fun setUpTextViewStyle() {
        val firstString = SpannableString(getStringFromRes(R.string.dont_have_an_account)).apply {
            color("#020614", 0, this.length)
        }
        val secondString = SpannableString(getStringFromRes(R.string.sign_up)).apply {
            val clickableSpan: ClickableSpan = object : ClickableSpan() {
                override fun onClick(p0: View) {
                    startActivity(Intent(this@SigninActivity, SignupActivity::class.java))
                }

                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.isUnderlineText = false
                }
            }
            this.setSpan(clickableSpan, 0, this.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            color("#100D40", 0, this.length)
            bold(0, this.length)
        }
        binding.tvDontHaveAccount.text =
            SpannableString(TextUtils.concat(firstString, " ", secondString))
        binding.tvDontHaveAccount.movementMethod = LinkMovementMethod.getInstance()
    }

    // Class Method: For dismiss keyboard
    private fun dismissKeyboard() {
        binding.baselayout.setOnClickListener {
            if (currentFocus != null) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            }
        }
    }

    // Overridden Onclick Method
    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btnSignin.id -> validation()
        }
    }

}