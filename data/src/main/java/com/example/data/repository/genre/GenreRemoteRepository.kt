package com.example.data.repository.genre

interface GenreRemoteRepository {

    suspend fun getListOfGenreById(ids: List<Long>): List<String>
}
