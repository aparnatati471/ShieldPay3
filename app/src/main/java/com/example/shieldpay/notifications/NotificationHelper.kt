package com.example.shieldpay.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.SystemClock
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.shieldpay.R

class NotificationHelper(
    val context: Context,
    val title: String,
    description: String,
    icon: Int,
    private val channelName: String
) : NotificationCompat.Builder(context, channelName) {

    /** Variables */
    private val NOTIFICATION_ID = 1
    private var inboxStyle = NotificationCompat.InboxStyle()
    private var i = 0

    /** Initializer */
    init {
        this.setSmallIcon(icon)
        this.setContentTitle(title)
        this.setContentText(description)
        this.priority = NotificationCompat.PRIORITY_DEFAULT
    }

    /** Class Method: Create Notification */
    fun createNotification(): NotificationHelper {
        val manager = NotificationManagerCompat.from(context)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(this.channelName, this.channelName,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            }
            manager.createNotificationChannel(channel)
        }
        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, this.build())
        return this
    }

    /** Class Method: Add Icon */
    fun addLargeIcon(icon: Int): NotificationHelper {
        this.setLargeIcon(BitmapFactory.decodeResource(context.resources, icon))
        return this
    }

    /** Class Method: Return pending intent */
    private fun <T> pendingIntent(className: Class<T>): PendingIntent {
        val intent = Intent(context, className)
        return PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )
    }

    /** Class Method: set pending intent */
    fun <T> addPendingIntent(className: Class<T>): NotificationHelper {
        this.setContentIntent(pendingIntent(className))
        return this
    }

    /** Class Method: Add Button Actions */
    fun <T> addActions(text: String, className: Class<T>): NotificationHelper {
        this.color = Color.BLUE
        this.addAction(R.drawable.back_arrow, text, pendingIntent(className))
        return this
    }

    /** Class Method: Group Notification */
    fun groupNotification(): NotificationHelper {
        i += 1
        inboxStyle.setBigContentTitle(context.getString(R.string.notifications_title))
        if(i % 2 == 0) {
            inboxStyle.addLine("Message from Brijesh $i")
        } else {
            inboxStyle.addLine("Message from Rishita $i")
        }
        this.setStyle(inboxStyle)
        return this
    }

    fun createProgressNotification(): NotificationHelper {
        this.setProgress(0,0, true)
        this.setOnlyAlertOnce(true)
        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, this.build())
        Thread(Runnable {
            var count = 0
            while (count <= 100) {
                count += 10
                Thread.sleep(1000)
                this.setProgress(100, count,false)
                NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, this.build())
            }
            this.setProgress(0,0,false)
            this.setContentText("Download completed!!")
            NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, this.build())
        }).start()
        return this
    }

}

