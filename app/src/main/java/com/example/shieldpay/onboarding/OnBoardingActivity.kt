package com.example.shieldpay.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewpager2.widget.ViewPager2
import com.example.shieldpay.Data
import com.example.shieldpay.R
import com.example.shieldpay.basesetup.BaseSharedPreferenceManager
import com.example.shieldpay.databinding.ActivityOnboardingBinding
import com.example.shieldpay.webservices.RetrofitOrHttpActivity

class OnBoardingActivity : AppCompatActivity(), View.OnClickListener {

    // Variables
    private lateinit var binding: ActivityOnboardingBinding
    private var dotsCount = 0
    private lateinit var dots: Array<AppCompatImageView?>

    // Overridden Method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.click = this
        binding.vpOnboarding.adapter = OnboardingAdapter(Data.onboardingdata(this))
        setUpOnBoardingIndicators()
    }

    // Class Methods
    private fun setUpOnBoardingIndicators() {
        dotsCount = Data.onboardingdata(this).count()
        dots = arrayOfNulls(dotsCount)
        val params = LinearLayout.LayoutParams(
            100, 100
        )
        (0 until dotsCount).forEach {
            val imageView = AppCompatImageView(this)
            imageView.setDrawable(R.drawable.unselected_dot)
            imageView.layoutParams = params
            binding.indicators.addView(imageView)
            dots[it] = imageView
        }
        dots[0]?.setImageDrawable(this.getDrawableRes(R.drawable.selected_dot))
        binding.vpOnboarding.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setSelectedDot(position)
                when (position) {
                    0, 1 -> {
                        binding.btnNext.setText(R.string.next_step)
                        binding.btnSkip.visibility = View.GONE
                        binding.tvSkip.visibility = View.VISIBLE
                    }
                    2 -> {
                        binding.btnNext.setText(R.string.create_account)
                        binding.tvSkip.visibility = View.GONE
                        binding.btnSkip.visibility = View.VISIBLE
                        binding.btnSkip.setBackgroundResource(R.drawable.btn_skip_background)
                        BaseSharedPreferenceManager.getInstance(this@OnBoardingActivity).saveOnboardStatus(true)
                    }
                }
            }
        })
    }

    // Class Method: Dot Selection Logic
    private fun setSelectedDot(index: Int) {
        if (index > dotsCount - 1) {
            return
        }
        dots.forEach {
            it?.setDrawable(R.drawable.unselected_dot)
        }
        dots[index]?.setDrawable(R.drawable.selected_dot)
    }

    // Method for navigate to next onboarding screen using next button
    private fun navigateToNext(): Int {
        return binding.vpOnboarding.currentItem + 1
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btnNext.id -> {
                if (binding.btnNext.text == "Next Step") {
                    binding.vpOnboarding.setCurrentItem(navigateToNext(), true)
                } else {
                    startActivity(Intent(this@OnBoardingActivity, RetrofitOrHttpActivity::class.java))
                }
            }
            binding.tvSkip.id -> startActivity(Intent(this, RetrofitOrHttpActivity::class.java))
            binding.btnSkip.id -> startActivity(Intent(this, RetrofitOrHttpActivity::class.java))
        }
    }

}