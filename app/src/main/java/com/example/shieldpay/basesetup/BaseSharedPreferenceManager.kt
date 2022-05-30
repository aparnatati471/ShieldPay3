package com.example.shieldpay.basesetup

import android.content.Context
import android.content.SharedPreferences
import com.example.shieldpay.webservices.http.LoginUserResponse
import com.google.gson.Gson

/** Constant Variables **/
const val isOnboard = "onboard"
const val isLogin = "login"
const val PREF_NAME = "SheildPay"

/** Shared Preference Manager Class **/
class BaseSharedPreferenceManager {

    companion object {

        /** Variables **/
        private val sharedPref = BaseSharedPreferenceManager()
        private lateinit var sharedPreferences: SharedPreferences
        private lateinit var editor: SharedPreferences.Editor

        /** Class Method **/
        fun getInstance(context: Context): BaseSharedPreferenceManager {
            sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            editor = sharedPreferences.edit()
            return sharedPref
        }

    }

    /** Class Methods **/
    fun saveOnboardStatus(status: Boolean) {
        editor.putBoolean(isOnboard, status).commit()
    }

    fun isOnboard(): Boolean {
        return sharedPreferences.getBoolean(isOnboard, false)
    }

    fun saveLoginStatus(token: String) {
        editor.putString(isLogin, token)
        editor.putBoolean(isLogin, true)
        editor.commit()
    }

    fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(isLogin, false)
    }

    fun clear() {
        editor.clear().commit()
    }

    fun remove(key: String) {
        editor.remove(key).commit()
    }

}
