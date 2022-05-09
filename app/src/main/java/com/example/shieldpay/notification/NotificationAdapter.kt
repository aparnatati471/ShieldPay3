package com.example.shieldpay.notification

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class NotificationAdapter(fragment: FragmentManager,
                          lifecycle: Lifecycle
) : FragmentStateAdapter(fragment, lifecycle) {

    companion object {
        val title = arrayOf("All Notification", "Unread")
    }

    // Overridden Methods
    override fun getItemCount(): Int {
        return title.count()
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> AllNoticationFragment()
            1 -> UnreadNotificationFragment()
            else -> AllNoticationFragment()
        }
    }

}