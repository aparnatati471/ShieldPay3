package com.example.shieldpay.basesetup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

/** Base Fragment Class **/
abstract class BaseFragment<viewBinding: ViewBinding, viewModel: ViewModel>(
    private val bindingInflater: (layoutInflater: LayoutInflater) -> viewBinding,
    private val VM: Class<viewModel>
): Fragment() {

    /** Variables **/
    lateinit var binding: viewBinding
    lateinit var vm: viewModel

    /** Overridden Method **/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindingInflater.invoke(inflater)
        vm = ViewModelProvider(this)[VM]
        return binding.root
    }

}