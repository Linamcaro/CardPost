package com.example.testcubepay.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testcubepay.model.CardInfo
import com.example.testcubepay.model.PostResponse
import com.example.testcubepay.repository.CardRemoteInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(application: Application,
    private val repository: CardRemoteInfo
) : AndroidViewModel(application) {

    var cardDataResponse: MutableLiveData<Response<PostResponse>> = MutableLiveData()

    //call the repository's send card info function
    fun sendCardInfo(cardInfo:CardInfo){
        Log.d("CardInfoTrace", "View Model Send Card Info function called")
        viewModelScope.launch{
            val response = repository.sendCardInfo(cardInfo)
            cardDataResponse.value = response
        }
    }

}