package com.example.tristagram2.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Beer(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("tagline") val tagline: String,
    @SerialName("description") val description: String,
    @SerialName("imageUrl") val imageUrl: String? = null,
)