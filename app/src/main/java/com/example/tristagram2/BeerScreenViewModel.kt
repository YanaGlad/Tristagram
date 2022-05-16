package com.example.tristagram2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tristagram2.api.Api
import com.example.tristagram2.dto.Beer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerScreenViewModel @Inject constructor(val api: Api) : ViewModel() {

    val beerList: MutableLiveData<List<Beer>> = MutableLiveData(listOf())

    companion object {
        const val name = "Samsung It School"
    }

    init {
        this.viewModelScope.launch { getData() }
    }

    suspend fun getData() {
        val response = api.getBeerList()
        if (response.isSuccessful) {
            beerList.value = response.body()!!
        }
    }
}
