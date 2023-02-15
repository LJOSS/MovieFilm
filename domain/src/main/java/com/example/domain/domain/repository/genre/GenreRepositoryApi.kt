package com.example.domain.domain.repository.genre

interface GenreRepositoryApi {

    suspend fun getListOfGenreById(ids: List<Long>): List<String>
}
