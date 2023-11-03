package com.example.testcubepay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.testcubepay.databinding.ActivityMainBinding
import com.example.testcubepay.model.CardInfo
import com.example.testcubepay.viewmodel.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]


        //when button is clicked send the card data
        binding.sendButton.setOnClickListener {
            val cardNumber = binding.cardNumberInputText.text.toString()
            val cardExpiration = binding.cardExpirationInputText.text.toString()
            val cvv = binding.cvvInputText.text.toString()

            val cardInfo = CardInfo(cardNumber, cardExpiration, cvv)
            sendCardInfo(cardInfo)


        }

        viewModel.cardDataResponse.observe(this) {response->
            Log.d("CardInfoTrace", response.code().toString())

            response.body()?.let { Log.d("CardInfoTrace", it.status) }

        }

    }


    private fun sendCardInfo(cardInfo: CardInfo) {
        Log.d("CardInfoTrace ","Main Activity:Send Card Info function called")
        Log.d("CardInfoTrace ",cardInfo.toString())
        viewModel.sendCardInfo(cardInfo)

    }

}