package com.example.tristagram2.api

import com.example.tristagram2.dto.Beer
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("beers")
    suspend fun getBeerList(): Response<List<Beer>>
}