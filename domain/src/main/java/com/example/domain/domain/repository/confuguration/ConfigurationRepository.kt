package com.example.domain.domain.repository.confuguration

interface ConfigurationRepository {

    suspend fun getPosterImageBaseUrl(): String

    suspend fun getOriginalImageBaseUrl(): String
}