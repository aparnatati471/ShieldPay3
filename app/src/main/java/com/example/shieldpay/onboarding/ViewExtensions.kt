package com.example.shieldpay.onboarding

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

// Extension for get drawable image
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

