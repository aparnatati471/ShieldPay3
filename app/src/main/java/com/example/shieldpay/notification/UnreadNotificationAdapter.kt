package com.example.shieldpay.notification

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shieldpay.databinding.SingleNotificationBinding

class UnreadNotificationAdapter(private var notificationDataList: ArrayList<NotificationModel>): RecyclerView.Adapter<UnreadNotificationAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: SingleNotificationBinding): RecyclerView.ViewHolder(binding.root)

    // Overridden Methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnreadNotificationAdapter.ViewHolder {
        val binding = SingleNotificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UnreadNotificationAdapter.ViewHolder, position: Int) {
        val notificationDetails = notificationDataList[position]
        notificationDetails.dot?.let { holder.binding.imgDot.setImageResource(it) }
        if(notificationDetails.dot == null) {
            holder.binding.notificationBackground.setBackgroundColor(Color.WHITE)
        }
        holder.binding.imgNotification.setImageResource(notificationDetails.image)
        holder.binding.txtTitle.text = notificationDetails.text
        holder.binding.txtTime.text = notificationDetails.time
    }

    override fun getItemCount(): Int {
        return notificationDataList.size
    }

}