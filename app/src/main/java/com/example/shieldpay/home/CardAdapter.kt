package com.example.shieldpay.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shieldpay.databinding.SingleCardBinding

class CardAdapter(private var cardDataList: ArrayList<CardModel>): RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: SingleCardBinding): RecyclerView.ViewHolder(binding.root)

    // Overridden Methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SingleCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardDetails = cardDataList[position]
        holder.binding.tvAccountNo.text = cardDetails.card_no
        holder.binding.tvAmount.text = cardDetails.card_amount
        holder.binding.tvDate.text = cardDetails.card_date
    }

    override fun getItemCount(): Int {
        return cardDataList.size
    }

}