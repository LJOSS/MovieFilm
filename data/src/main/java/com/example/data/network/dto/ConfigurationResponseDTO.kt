package com.example.data.network.dto

import com.squareup.moshi.Json


data class ConfigurationResponseDTO(
    @Json(name = "images")
    val imagesConfig: ImagesConfiguration
)

data class ImagesConfiguration(
    @Json(name = "secure_base_url")
    val secureBaseUrl: String,
    @Json(name = "poster_sizes")
    val posterSizes: List<String>
)
