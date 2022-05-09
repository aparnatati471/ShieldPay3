package com.example.shieldpay.onboarding

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import android.graphics.Color
import android.graphics.Typeface
import android.text.Editable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.util.Patterns
import android.view.Window
import android.widget.EditText
import com.example.shieldpay.R

fun Context.getDrawableRes(@DrawableRes id: Int): Drawable? {
    return ContextCompat.getDrawable(this, id)
}

// Extension for set drawable image
fun ImageView.setDrawable(@DrawableRes id: Int) {
    this.setImageDrawable(this.context.getDrawableRes(id))
}

// Extension for set string resource
fun Context.getStringFromRes(id: Int): String {
    return this.getString(id)
}

// Extension for convert hex string to color
fun Context.getColorDrawable(id: Int): String {
    return "#" + Integer.toHexString(ContextCompat.getColor(this, id))
}

// Extension for color the text using SpannableString
fun SpannableString.color(color: String, startIndex: Int = 0, endIndex: Int = length): SpannableString {
    this.setSpan(ForegroundColorSpan(Color.parseColor(color)), startIndex, endIndex, 0)
    return this
}

// Extension for bold the text using SpannableString
fun SpannableString.bold(start: Int, end: Int): SpannableString {
    this.setSpan(StyleSpan(Typeface.BOLD), start, end, 0)
    return this
}

// Extension for underline the text using SpannableString
fun SpannableString.underline(start: Int, end: Int): SpannableString {
    this.setSpan(UnderlineSpan(), start, end, 0)
    return this
}

// Extension for setting the status bar color blue
fun Window.setStatusBarColorBlue() {
    this.statusBarColor = Color.parseColor(this.context.getColorDrawable(R.color.dot_selected))
}

// Extension for setting the status bar color white
fun Window.setStatusBarColorWhite() {
    this.statusBarColor = Color.parseColor(this.context.getColorDrawable(R.color.white))
}

// Extension for validations
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            afterTextChanged.invoke(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }
    })
}

fun EditText.validate(message: String, validator: (String) -> Boolean) {
    this.afterTextChanged {
        this.error = if (validator(it)) null else message
    }
    this.error = if (validator(this.text.toString())) null else message
}

fun String.isValidName() : Boolean = this.isNotEmpty()

fun String.isValidEmail(): Boolean = this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.isValidPassword(): Boolean = this.isNotEmpty() && length >= 8

