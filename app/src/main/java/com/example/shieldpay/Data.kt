package com.example.shieldpay

import android.content.Context
import com.example.shieldpay.onboarding.OnboardingModel
import com.example.shieldpay.onboarding.getStringFromRes

class Data {

    companion object getData {

        fun onboardingdata(context: Context): ArrayList<OnboardingModel> {
            val onboardingDataList = ArrayList<OnboardingModel>()
            context.apply {
                onboardingDataList.add(OnboardingModel(
                    R.drawable.send_money,
                    getStringFromRes(R.string.titleOne),
                    getStringFromRes(R.string.descriptionOne)
                ))
                onboardingDataList.add(OnboardingModel(
                    R.drawable.request_money,
                    getStringFromRes(R.string.titleTwo),
                    getStringFromRes(R.string.descriptionTwo)
                ))
                onboardingDataList.add(OnboardingModel(
                    R.drawable.hand,
                    getStringFromRes(R.string.titleThree),
                    getStringFromRes(R.string.descriptionThree)
                ))
            }
            return onboardingDataList
        }

    }

}