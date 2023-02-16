package com.example.data.repository

import com.example.data.network.ApiService
import com.example.data.network.entity.ConfigurationResponse
import com.example.domain.domain.repository.confuguration.ConfigurationRepositoryApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class ConfigurationRepository(
    private val apiService: ApiService
) : ConfigurationRepositoryApi {

    private var cachedConfiguration: ConfigurationResponse? = null

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

    private suspend fun getConfiguration(): ConfigurationResponse? {
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
