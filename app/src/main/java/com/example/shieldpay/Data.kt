package com.example.shieldpay

import android.content.Context
import com.example.shieldpay.forgotpassword.CountryModel
import com.example.shieldpay.home.CardModel
import com.example.shieldpay.home.HomeFragment
import com.example.shieldpay.onboarding.OnboardingModel

class Data {

    companion object getData {

        fun onboardingdata(context: Context): ArrayList<OnboardingModel> {
            val onboardingDataList = ArrayList<OnboardingModel>()
            onboardingDataList.add(OnboardingModel(
                R.drawable.send_money,
                context.getString(R.string.titleOne),
                context.getString(R.string.descriptionOne)
            ))
            onboardingDataList.add(OnboardingModel(
                R.drawable.request_money,
                context.getString(R.string.titleTwo),
                context.getString(R.string.descriptionTwo)
            ))
            onboardingDataList.add(OnboardingModel(
                R.drawable.hand,
                context.getString(R.string.titleThree),
                context.getString(R.string.descriptionThree)
            ))
            return onboardingDataList
        }

        fun spinnerData(context: Context): ArrayList<CountryModel> {
            val countryList = ArrayList<CountryModel>()
            countryList.add(CountryModel(
                R.drawable.flag_three,
                context.getString(R.string.first)
            ))
            countryList.add(CountryModel(
                R.drawable.flag_two,
                context.getString(R.string.second)
            ))
            countryList.add(CountryModel(
                R.drawable.flag,
                context.getString(R.string.third)
            ))
            countryList.add(CountryModel(
                R.drawable.flag_four,
                context.getString(R.string.fourth)
            ))
            countryList.add(CountryModel(
                R.drawable.flag_five,
                context.getString(R.string.fifth)
            ))
            countryList.add(CountryModel(
                R.drawable.flag_six,
                context.getString(R.string.sixth)
            ))
            countryList.add(CountryModel(
                R.drawable.flag_seven,
                context.getString(R.string.seneventh)
            ))
            return countryList
        }

        fun cardData(context: HomeFragment): ArrayList<CardModel> {
            val cardList = ArrayList<CardModel>()
            cardList.add(CardModel(context.getString(R.string.card_one_no), context.getString(R.string.card_one_amount), context.getString(R.string.card_one_date)))
            cardList.add(CardModel(context.getString(R.string.card_two_no), context.getString(R.string.card_two_amount), context.getString(R.string.card_two_date)))
            cardList.add(CardModel(context.getString(R.string.card_three_no), context.getString(R.string.card_three_amount), context.getString(R.string.card_three_date)))
            cardList.add(CardModel(context.getString(R.string.card_one_no), context.getString(R.string.card_one_amount), context.getString(R.string.card_one_date)))
            return cardList
        }

    }

}