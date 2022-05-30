package com.example.shieldpay.basesetup

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

/** Base Activity Class **/
abstract class BaseActivity<viewBinding: ViewBinding, viewModel: ViewModel>(
    private val bindingInflater: (LayoutInflater) -> viewBinding,
    private val VM: Class<viewModel>
): AppCompatActivity() {

    /** Variables **/
    lateinit var binding: viewBinding
    lateinit var vm: viewModel

    /** Overridden Method **/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingInflater.invoke(layoutInflater)
        vm = ViewModelProvider(this)[VM]
        setContentView(binding.root)
    }

}