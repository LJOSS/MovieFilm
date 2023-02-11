package com.example.movie_project.domain.repository.genre

import com.example.data.repository.genre.GenreRemoteRepository

class GenreRepositoryImpl(
    private val genreRemoteRepository: GenreRemoteRepository
) : GenreRepository {

    override suspend fun getListOfGenreById(ids: List<Long>): List<String> {
        return genreRemoteRepository.getListOfGenreById(ids)
    }
}