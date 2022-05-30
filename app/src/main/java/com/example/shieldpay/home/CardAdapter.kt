package com.example.shieldpay.home

import com.example.shieldpay.R
import com.example.shieldpay.basesetup.BaseRecyclerViewAdapter

class CardAdapter(val data: ArrayList<CardModel>): BaseRecyclerViewAdapter<CardModel>(data) {

    override fun getItemViewType(position: Int): Int {
        return R.layout.single_card
    }

}