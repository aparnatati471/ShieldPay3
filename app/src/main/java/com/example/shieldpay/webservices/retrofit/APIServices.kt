package com.example.shieldpay.webservices.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIServices {

    companion object {

        private const val BASE_URL = "https://reqres.in/"

        val retrofitBuilder: ApiInterface by lazy {
            return@lazy Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        }

    }

}