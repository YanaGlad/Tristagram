package com.example.tristagram2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tristagram2.api.Api
import com.example.tristagram2.dto.Beer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerScreenViewModel @Inject constructor(val api: Api) : ViewModel() {

    private val _beerList: MutableStateFlow<List<Beer>> = MutableStateFlow(listOf())
    val beerList: StateFlow<List<Beer>> = _beerList.asStateFlow()

    init {
        this.viewModelScope.launch { getData() }
    }

    private suspend fun getData() {
        val response = api.getBeerList()
        if (response.isSuccessful) {
            _beerList.value = response.body()!!
        }
    }
}
