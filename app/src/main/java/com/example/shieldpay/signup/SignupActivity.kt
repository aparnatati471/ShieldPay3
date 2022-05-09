package com.example.shieldpay.signup

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.TextUtils
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.shieldpay.MainActivity
import com.example.shieldpay.R
import com.example.shieldpay.databinding.ActivitySignupBinding
import com.example.shieldpay.forgotpassword.PhoneActivity
import com.example.shieldpay.onboarding.bold
import com.example.shieldpay.onboarding.color
import com.example.shieldpay.onboarding.dismissKeyboard
import com.example.shieldpay.onboarding.getStringFromRes
import com.example.shieldpay.onboarding.isValidEmail
import com.example.shieldpay.onboarding.isValidName
import com.example.shieldpay.onboarding.isValidPassword
import com.example.shieldpay.onboarding.setStatusBarColorWhite
import com.example.shieldpay.onboarding.underline
import com.example.shieldpay.onboarding.validate
import com.example.shieldpay.signin.SigninActivity

class SignupActivity : AppCompatActivity(), View.OnClickListener {

    // Variables
    private lateinit var binding: ActivitySignupBinding
    private var check = true

    // Overridden Method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.click = this
        window.apply {
            setStatusBarColorWhite()
        }
        setUpCheckBoxTextStyle()
        setUpTextViewStyle()
        binding.baselayout.apply {
            dismissKeyboard(this)
        }
    }

    // Class Method: For Validation
    private fun validation() {
        if (check) {
            binding.edtName.validate(getString(R.string.name_validation)) { s -> s.isValidName() }
            binding.edtEmailAddress.validate(getString(R.string.email_validation)) { s -> s.isValidEmail() }
            binding.edtPass.validate(getString(R.string.password_validation)) { s -> s.isValidPassword() }
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
        check = false
    }

    // Class Method: Setting style of the text
    private fun setUpCheckBoxTextStyle() {
        val firstString = SpannableString(getStringFromRes(R.string.agree)).apply {
            color("#020614", 0, this.length)
        }
        val secondString = SpannableString(getStringFromRes(R.string.terms_and_condition)).apply {
            color("#000000", 0, this.length)
            underline(0, this.length)
        }
        binding.chkTermsAndConditions.text =
            SpannableString(TextUtils.concat(firstString, " ", secondString))
    }

    // Class Method: Setting style of the text
    private fun setUpTextViewStyle() {
        val firstString =
            SpannableString(getStringFromRes(R.string.already_have_an_account)).apply {
                color("#020614", 0, this.length)
            }
        val secondString = SpannableString(getStringFromRes(R.string.sign_in)).apply {
            val clickableSpan: ClickableSpan = object : ClickableSpan() {
                override fun onClick(p0: View) {
                    startActivity(Intent(this@SignupActivity, SigninActivity::class.java))
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
        binding.tvAlreadyAccount.text =
            SpannableString(TextUtils.concat(firstString, " ", secondString))
        binding.tvAlreadyAccount.movementMethod = LinkMovementMethod.getInstance()
    }

    // Overridden Onclick Method
    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btnSignup.id -> validation()
            binding.btnPhone.id -> startActivity(Intent(this, PhoneActivity::class.java))
        }
    }

}