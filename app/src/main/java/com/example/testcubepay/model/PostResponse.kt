package com.example.testcubepay.model


import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("authorizationCode")
    val authorizationCode: Any,
    @SerializedName("status")
    val status: String
)