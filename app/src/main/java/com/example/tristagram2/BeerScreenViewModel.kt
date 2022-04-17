package com.example.tristagram2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tristagram2.api.Api
import com.example.tristagram2.api.ApiService
import com.example.tristagram2.dto.Beer
import kotlinx.coroutines.launch

class BeerScreenViewModel : ViewModel() {

    val beerList: MutableLiveData<List<Beer>> = MutableLiveData(listOf())

    val api: Api

    init {
        api = ApiService.getInstance("https://api.punkapi.com/v2/").create(Api::class.java)
        this.viewModelScope.launch { getData() }
    }

    suspend fun getData() {
        val response = api.getBeerList()
        if (response.isSuccessful) {
            beerList.value = response.body()!!
        }
    }
}