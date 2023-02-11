package com.example.movie_project.domain.repository.confuguration

import com.example.data.repository.configuration.RemoteConfigurationRepository

class ConfigurationRepositoryImpl(
    private val remoteConfigurationRepository: RemoteConfigurationRepository
): ConfigurationRepository {

    override suspend fun getPosterImageBaseUrl(): String {
        return remoteConfigurationRepository.getPosterImageBaseUrl()
    }

    override suspend fun getOriginalImageBaseUrl(): String {
        return remoteConfigurationRepository.getOriginalImageBaseUrl()
    }

}