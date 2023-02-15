package com.example.domain.domain.repository.confuguration

interface ConfigurationRepositoryApi {

    suspend fun getPosterImageBaseUrl(): String

    suspend fun getOriginalImageBaseUrl(): String
}
