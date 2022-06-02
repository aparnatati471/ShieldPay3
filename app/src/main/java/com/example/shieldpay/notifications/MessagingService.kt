package com.example.shieldpay.notifications

import com.example.shieldpay.R
import com.example.shieldpay.forgotpassword.AccountCreatedActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MessagingService: FirebaseMessagingService() {

    /** Overridden Method */
    override fun onMessageReceived(message: RemoteMessage) {
       if (message.notification != null) {
           message.notification?.title?.let { title ->
               message.notification?.body?.let { body ->
                   showNotification(title = title, subtitle = body)
               }
           }
       }
    }

    /** Class Method */
    private fun showNotification(title: String, subtitle: String) {
        NotificationHelper(
            this,
            title,
            subtitle,
            R.drawable.logo,
            "SheildPay"
        ).addPendingIntent(AccountCreatedActivity::class.java).addLargeIcon(R.drawable.account_created).createNotification()
    }

}