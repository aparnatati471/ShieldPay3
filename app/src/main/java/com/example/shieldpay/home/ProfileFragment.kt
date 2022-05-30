package com.example.shieldpay.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.shieldpay.basesetup.BaseFragment
import com.example.shieldpay.basesetup.BaseSharedPreferenceManager
import com.example.shieldpay.basesetup.isLogin
import com.example.shieldpay.databinding.FragmentProfileBinding
import com.example.shieldpay.webservices.RetrofitOrHttpActivity
import com.example.shieldpay.webservices.http.AuthenticationViewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding, AuthenticationViewModel>(
    FragmentProfileBinding::inflate,
    AuthenticationViewModel::class.java
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogout.setOnClickListener {
            startActivity(Intent(context, RetrofitOrHttpActivity::class.java))
            context?.let { it1 -> BaseSharedPreferenceManager.getInstance(it1).remove(isLogin) }
        }
    }

}