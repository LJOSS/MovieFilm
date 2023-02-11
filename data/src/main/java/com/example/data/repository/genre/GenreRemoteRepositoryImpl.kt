package com.example.data.repository.genre

import com.example.data.network.APIService

class GenreRemoteRepositoryImpl(
    private val apiService: APIService
) : GenreRemoteRepository {

    private var cachedGenres: Map<Long, String> = emptyMap()

    suspend fun getGenres(): Map<Long, String> {
        if (cachedGenres.isEmpty()) {
            runCatching {
                apiService.loadGenres("en")
            }.let {
                cachedGenres = it.getOrNull()?.genres?.associate { genre ->
                    genre.id to genre.name
                } ?: emptyMap()
            }
        }
        return cachedGenres
    }

    override suspend fun getListOfGenreById(ids: List<Long>): List<String> {
        return ids.mapNotNull { getGenres()[it] }
    }
}