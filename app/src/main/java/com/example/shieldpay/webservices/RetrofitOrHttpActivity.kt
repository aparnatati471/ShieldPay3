package com.example.shieldpay.webservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.shieldpay.R
import com.example.shieldpay.basesetup.BaseSharedPreferenceManager
import com.example.shieldpay.databinding.ActivityRetrofitOrHttpBinding
import com.example.shieldpay.home.BottomNavigationActivity
import com.example.shieldpay.signup.SignupActivity
import com.example.shieldpay.webservices.http.APISelectionType

class RetrofitOrHttpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRetrofitOrHttpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitOrHttpBinding.inflate(layoutInflater)
        binding.click = this
        setContentView(binding.root)
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            binding.btnHttp.id -> {
                APISelectionType.SelectAPI.apiType = getString(R.string.http)
                navigateToNext()
            }
            binding.btnRetrofit.id -> {
                APISelectionType.SelectAPI.apiType = getString(R.string.retrofit)
                navigateToNext()
            }
        }
    }

    private fun navigateToNext() {
        startActivity(Intent(this, SignupActivity::class.java))
    }

}