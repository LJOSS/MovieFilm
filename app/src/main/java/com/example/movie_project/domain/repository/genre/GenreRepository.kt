package com.example.movie_project.domain.repository.genre

interface GenreRepository {

    suspend fun getListOfGenreById(ids: List<Long>): List<String>
}