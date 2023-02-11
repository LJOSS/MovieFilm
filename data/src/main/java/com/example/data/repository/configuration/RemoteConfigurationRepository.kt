package com.example.data.repository.configuration

interface RemoteConfigurationRepository {

    suspend fun getPosterImageBaseUrl(): String

    suspend fun getOriginalImageBaseUrl(): String
}
