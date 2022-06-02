package com.example.shieldpay.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.core.app.NotificationManagerCompat
import androidx.media.app.NotificationCompat
import com.example.shieldpay.R
import com.example.shieldpay.basesetup.BaseActivity
import com.example.shieldpay.databinding.ActivityNotification2Binding
import com.example.shieldpay.forgotpassword.AccountCreatedActivity
import com.example.shieldpay.webservices.http.AuthenticationViewModel


class NotificationActivity : BaseActivity<ActivityNotification2Binding, AuthenticationViewModel>(
    ActivityNotification2Binding::inflate,
    AuthenticationViewModel::class.java
), View.OnClickListener {

    /** Variables */
    private lateinit var objGroupNotification: NotificationHelper
    val maxProgress = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.click = this
        objGroupNotification = NotificationHelper(this,
            resources.getString(R.string.group_notification),
            resources.getString(R.string.messages),
            R.drawable.logo,
            "SheildPay")
    }

    /** Overridden Method */
    override fun onClick(p0: View?) {
        when(p0?.id) {
            binding.btnSimpleNotification.id -> {
                NotificationHelper(
                    this,
                    getString(R.string.channel_name),
                    getString(R.string.channel_description),
                    R.drawable.logo,
                    "SheildPay"
                ).addLargeIcon(R.drawable.account_created).addPendingIntent(AccountCreatedActivity::class.java).addActions(resources.getString(R.string.show), AccountCreatedActivity::class.java).createNotification()
            }
            binding.btnGroupNotification.id -> {
               objGroupNotification.groupNotification().createNotification()
            }
            binding.btnProgressNotification.id -> {
                NotificationHelper(this,
                    getString(R.string.channel_name),
                    getString(R.string.channel_description),
                    R.drawable.logo,
                    "SheildPay").createProgressNotification().createNotification()
            }
        }
    }

}