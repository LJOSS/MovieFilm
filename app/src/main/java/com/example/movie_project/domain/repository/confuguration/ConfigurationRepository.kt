package com.example.movie_project.domain.repository.confuguration

interface ConfigurationRepository {

    suspend fun getPosterImageBaseUrl(): String

    suspend fun getOriginalImageBaseUrl(): String
}