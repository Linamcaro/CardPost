package com.example.testcubepay.data

import com.example.testcubepay.model.CardInfo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import android.util.Log
import com.example.testcubepay.model.PostResponse


interface CardApi {

    @POST("/CubeDemo/bank/card")
    suspend fun sendCardInfo(@Body cardInfo: CardInfo): Response<PostResponse>

}