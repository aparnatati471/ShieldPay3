package com.example.shieldpay.webservices.http

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _failureResult = MutableLiveData<String>()
    val failureResult: LiveData<String>
        get() = _failureResult

    fun setLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    fun setFailureResult(failureValue: String) {
        _failureResult.value = failureValue
    }

}