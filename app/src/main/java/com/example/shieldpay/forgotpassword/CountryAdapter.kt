package com.example.shieldpay.forgotpassword

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.shieldpay.databinding.SpinnerItemBinding

class CountryAdapter(context: Context, countryList: List<CountryModel>): ArrayAdapter<CountryModel>(context, 0, countryList) {

    // Overridden Methods
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        val country = getItem(position)
        val binding = SpinnerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        if (country != null) {
            binding.countryImage.setImageResource(country.image)
            binding.countryName.text = country.name
        }
        return binding.root
    }

}