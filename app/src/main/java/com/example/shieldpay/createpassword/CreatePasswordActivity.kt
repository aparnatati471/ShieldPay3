package com.example.shieldpay.createpassword

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.shieldpay.databinding.ActivityCreatePasswordBinding

class CreatePasswordActivity : AppCompatActivity() {

    private lateinit var viewModel: PinViewModel

    private lateinit var binding: ActivityCreatePasswordBinding
    var number: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatePasswordBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[PinViewModel::class.java]
        setContentView(binding.root)
//        val no = binding.editTextEnterMpin
//        val circleOne = binding.first
//        val circleTwo = binding.two
//        val circleThree = binding.three
//        val circleFour = binding.four
//        no.inputType = InputType.TYPE_CLASS_NUMBER
////        no.isFocusableInTouchMode = true
//        no.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
//            override fun afterTextChanged(s: Editable) {
//                Log.d("TAG", "onKey: screen key pressed")
//                when(s.length) {
//                    0 -> {
//                        circleOne.setImageResource(R.drawable.checkbox_off_background)
//                        circleTwo.setImageResource(R.drawable.checkbox_off_background)
//                        circleThree.setImageResource(R.drawable.checkbox_off_background)
//                        circleFour.setImageResource(R.drawable.checkbox_off_background)
//                    }
//                    1 -> {
//                        number = binding.editTextEnterMpin.text.toString()
//                        circleOne.requestFocus()
//                        circleOne.setImageResource(R.drawable.checkbox_on_background)
//                        circleTwo.setImageResource(R.drawable.checkbox_off_background)
//                        circleThree.setImageResource(R.drawable.checkbox_off_background)
//                        circleFour.setImageResource(R.drawable.checkbox_off_background)
//                    }
//                    2 -> {
//                        number = binding.editTextEnterMpin.text.toString()
//                        circleTwo.requestFocus()
//                        circleOne.setImageResource(R.drawable.checkbox_on_background)
//                        circleTwo.setImageResource(R.drawable.checkbox_on_background)
//                        circleThree.setImageResource(R.drawable.checkbox_off_background)
//                        circleFour.setImageResource(R.drawable.checkbox_off_background)
//                    }
//                    3 -> {
//                        number = binding.editTextEnterMpin.text.toString()
//                        circleThree.requestFocus()
//                        circleOne.setImageResource(R.drawable.checkbox_on_background)
//                        circleTwo.setImageResource(R.drawable.checkbox_on_background)
//                        circleThree.setImageResource(R.drawable.checkbox_on_background)
//                        circleFour.setImageResource(R.drawable.checkbox_off_background)
//                    }
//                    4 -> {
//                        number = binding.editTextEnterMpin.text.toString()
//                        circleFour.requestFocus()
//                        circleOne.setImageResource(R.drawable.checkbox_on_background)
//                        circleTwo.setImageResource(R.drawable.checkbox_on_background)
//                        circleThree.setImageResource(R.drawable.checkbox_on_background)
//                        circleFour.setImageResource(R.drawable.checkbox_on_background)
//                        Log.d("Number", number.toString())
//                    }
//                }
//            }
//
//        })
    }
}