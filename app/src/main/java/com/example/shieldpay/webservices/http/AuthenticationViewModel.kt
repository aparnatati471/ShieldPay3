package com.example.shieldpay.webservices.http

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.json.JSONObject

class AuthenticationViewModel : BaseViewModel() {

    private val _registerResult = MutableLiveData<RegisterUserResponse>()
    val registerResult: LiveData<RegisterUserResponse>
        get() = _registerResult

    private val _loginResult = MutableLiveData<LoginUserResponse>()
    val loginResult: LiveData<LoginUserResponse>
        get() = _loginResult

    fun httpRegisterVM(email: String, password: String) {
        viewModelScope.launch {
            val data = JSONObject().apply {
                put("email", email)
                put("password", password)
            }
            setLoading(true)
            GenericFunctions.httpRegister(
                data,
                object : APIResult<RegisterUserResponse, Error> {
                    override fun onSuccess(success: RegisterUserResponse) {
                        _registerResult.value = success
                        setLoading(false)
                    }

                    override fun onFailure(failure: Error) {
                        setFailureResult(failure.error)
                        setLoading(false)
                    }
                }
            )
        }
    }

    fun httpLoginVM(email: String, password: String) {
        viewModelScope.launch {
            val data = JSONObject().apply {
                put("email", email)
                put("password", password)
            }
            setLoading(true)
            GenericFunctions.httpLogin(
                data,
                object : APIResult<LoginUserResponse, Error> {
                    override fun onSuccess(success: LoginUserResponse) {
                        _loginResult.value = success
                        setLoading(false)
                    }

                    override fun onFailure(failure: Error) {
                        setFailureResult(failure.error)
                        setLoading(false)
                    }
                }
            )
        }
    }

}