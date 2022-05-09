package com.example.shieldpay.webservices.http

data class AuthenticationUserRequest(
    val email: String,
    val password: String
)

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



