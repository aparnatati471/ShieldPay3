package com.example.shieldpay.basesetup

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.shieldpay.BR

/** Base RecyclerView Adapter Class **/
abstract class BaseRecyclerViewAdapter<modelClass>(var dataList: ArrayList<modelClass>):
    RecyclerView.Adapter<BaseRecyclerViewAdapter<modelClass>.BaseViewHolder>() {

    inner class BaseViewHolder(val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root)

    /** Overridden Methods **/
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
        return BaseViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val dataOne = dataList[position]
        holder.binding.setVariable(BR.data, dataOne)
    }

}

