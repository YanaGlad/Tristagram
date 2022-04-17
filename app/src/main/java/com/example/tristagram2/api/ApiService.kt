package com.example.tristagram2.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object ApiService {
    //private lateinit var DOMAIN : String //= "https://api.nasa.gov/"
    public var builder: Retrofit.Builder? = null
        get() = field

    public fun getInstance(domain : String): Retrofit {
        if (builder == null) {
            val okHttpBuiler: OkHttpClient.Builder = OkHttpClient.Builder()

            val contentType = MediaType.get("application/json")
            val json = Json { ignoreUnknownKeys = true }

            builder = Retrofit.Builder()
                .baseUrl(domain)
                .addConverterFactory(json.asConverterFactory(contentType))
                .client(okHttpBuiler.build())
        }
        return builder!!.build()
    }
}