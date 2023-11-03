package com.example.testcubepay.repository

import android.util.Log
import com.example.testcubepay.data.CardApi
import com.example.testcubepay.model.CardInfo
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Response
import javax.inject.Inject

@ViewModelScoped
class CardRemoteInfo @Inject constructor(private val cardApi: CardApi) {

    suspend fun sendCardInfo(cardInfo: CardInfo): Response<CardInfo> {

        Log.d("CardInfoTrace","Repository CardRemoteInfo function called")

      return cardApi.sendCardInfo(cardInfo)
    }
}