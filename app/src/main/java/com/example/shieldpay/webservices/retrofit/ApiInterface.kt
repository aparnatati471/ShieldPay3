package com.example.shieldpay.webservices.retrofit

import com.example.shieldpay.webservices.http.AuthenticationUserRequest
import com.example.shieldpay.webservices.http.LoginUserResponse
import com.example.shieldpay.webservices.http.RegisterUserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("api/register")
    fun register(@Body register: AuthenticationUserRequest): retrofit2.Call<RegisterUserResponse>

    @POST("api/login")
    fun login(@Body login: AuthenticationUserRequest): retrofit2.Call<LoginUserResponse>

}