package com.example.shieldpay.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shieldpay.databinding.ActivitySplashBinding
import com.example.shieldpay.onboarding.OnBoardingActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val t: Thread = object : Thread() {
            override fun run() {
                try {
                    //sleep thread for 3 seconds, time in milliseconds
                    sleep(3000)

                    //start new activity
                    val i = Intent(this@SplashActivity, OnBoardingActivity::class.java)
                    startActivity(i)

                    //destroying Splash activity
                    finish()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        t.start()
    }
}