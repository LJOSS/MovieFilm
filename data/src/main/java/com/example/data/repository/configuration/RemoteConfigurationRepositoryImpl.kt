package com.example.data.repository.configuration

import com.example.data.network.APIService
import com.example.data.network.dto.ConfigurationResponseDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteConfigurationRepositoryImpl(
    private val apiService: APIService
) : RemoteConfigurationRepository {

    private var cachedConfiguration: ConfigurationResponseDTO? = null

    override suspend fun getPosterImageBaseUrl(): String {
        return getConfiguration()?.imagesConfig?.let {
            it.secureBaseUrl + it.posterSizes[it.posterSizes.lastIndex / 2]
        } ?: ""
    }

    override suspend fun getOriginalImageBaseUrl(): String {
        return getConfiguration()?.imagesConfig?.let {
            it.secureBaseUrl + it.posterSizes.last()
        } ?: ""
    }

    private suspend fun getConfiguration(): ConfigurationResponseDTO? {
        if (cachedConfiguration == null) {
            withContext(Dispatchers.IO) {
                runCatching {
                    apiService.getConfiguration()
                }.let {
                    if (it.isSuccess) {
                        cachedConfiguration = it.getOrNull()
                    }
                }
            }
        }
        return cachedConfiguration
    }
}