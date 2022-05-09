package com.example.shieldpay.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shieldpay.databinding.OnboardingScreenBinding

class OnboardingAdapter(private val onboardingData: ArrayList<OnboardingModel>) :
    RecyclerView.Adapter<OnboardingAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: OnboardingScreenBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            OnboardingScreenBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val onboardData: OnboardingModel = onboardingData[position]
        holder.binding.imgOnboarding.setImageResource(onboardData.image)
        holder.binding.txtTitle.text = onboardData.title
        holder.binding.txtDescription.text = onboardData.description
    }

    override fun getItemCount(): Int {
        return onboardingData.size
    }

}