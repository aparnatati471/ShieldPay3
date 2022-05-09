package com.example.shieldpay.createpassword

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PinViewModel: ViewModel() {

    val pinCode = MutableLiveData<String>()

    val numPadListener = object : NumberPadInterface {
        override fun onNumberClicked(number: Char) {
            val existingPinCode = pinCode.value ?: ""
            val newPassCode = existingPinCode + number
            pinCode.postValue(newPassCode)
        }

        override fun onEraseClicked() {
            val droppedLast = pinCode.value?.dropLast(1) ?: ""
            pinCode.postValue(droppedLast)
        }
    }

}