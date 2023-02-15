package com.example.domain.domain.repository.genre

interface GenreRepository {

    suspend fun getListOfGenreById(ids: List<Long>): List<String>
}
