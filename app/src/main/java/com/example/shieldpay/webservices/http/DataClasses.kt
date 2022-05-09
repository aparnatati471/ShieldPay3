package com.example.shieldpay.webservices.http

data class RegisterUserResponse(
    val id: Int,
    val token: String
)

data class LoginUserResponse(
    val token: String
)

data class Error(
    val error: String
)



