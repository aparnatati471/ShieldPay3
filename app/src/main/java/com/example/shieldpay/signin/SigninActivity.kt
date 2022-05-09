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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.shieldpay.R
import com.example.shieldpay.databinding.ActivitySigninBinding
import com.example.shieldpay.home.BottomNavigationActivity
import com.example.shieldpay.onboarding.bold
import com.example.shieldpay.onboarding.color
import com.example.shieldpay.onboarding.dismissKeyboard
import com.example.shieldpay.onboarding.getStringFromRes
import com.example.shieldpay.onboarding.isValidEmail
import com.example.shieldpay.onboarding.isValidPassword
import com.example.shieldpay.onboarding.setStatusBarColorBlue
import com.example.shieldpay.onboarding.validate
import com.example.shieldpay.signup.SignupActivity
import com.example.shieldpay.webservices.http.APISelectionType
import com.example.shieldpay.webservices.http.AuthenticationViewModel

class SigninActivity : AppCompatActivity(), View.OnClickListener {

    // Variables
    private lateinit var binding: ActivitySigninBinding
    private lateinit var vm: AuthenticationViewModel
    private var check = true

    // Overridden Method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        vm = ViewModelProvider(this)[AuthenticationViewModel::class.java]
        binding.click = this
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
        binding.baselayout.apply {
            dismissKeyboard(this)
        }
        observables()
    }

    private fun observables() {
        vm.loginResult.observe(this) {
            Toast.makeText(this, it.token, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, BottomNavigationActivity::class.java))
        }
        vm.failureResult.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
        vm.isLoading.observe(this) {
            if(it) {
                binding.progressCircular.visibility = View.VISIBLE
            } else {
                binding.progressCircular.visibility = View.INVISIBLE
            }
        }
    }

    // Class Method: For Validation
    private fun validation() {
        if (check) {
            binding.edtEmailAddress.validate(getString(R.string.email_validation)) { s -> s.isValidEmail() }
            binding.edtPass.validate(getString(R.string.password_validation)) { s -> s.isValidPassword() }
        } else {
            startActivity(Intent(this, BottomNavigationActivity::class.java))
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

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btnSignin.id -> {
                validation()
                when(APISelectionType.SelectAPI.apiType) {
                    getString(R.string.retrofit) -> {
                        Log.d("Success", getString(R.string.retrofit))
                        vm.retrofitLoginVM(binding.edtEmailAddress.text.toString(), binding.edtPass.text.toString())
                    }
                    getString(R.string.http) -> {
                        Log.d("Success", getString(R.string.http))
                        vm.httpLoginVM(binding.edtEmailAddress.text.toString(), binding.edtPass.text.toString())
                    }
                }
            }
        }
    }

}