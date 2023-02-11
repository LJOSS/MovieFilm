package com.example.movie_project.domain.repository.movie

import com.example.data.repository.movie.MovieRemoteRepository
import com.example.movie_project.domain.entity.MovieInfo
import com.example.movie_project.domain.entity.MoviePagedInfo
import com.example.movie_project.domain.entity.toMovieInfo
import com.example.movie_project.domain.entity.toMoviePagedInfo

class MovieRepositoryImpl(
    private val movieRemoteRepository: MovieRemoteRepository
) : MovieRepository {

    override suspend fun getMovieList(page: Int, language: String): MoviePagedInfo {
        return movieRemoteRepository.getMovieList(page, language).toMoviePagedInfo()
    }

    override suspend fun getMovieInfo(movieId: Long, language: String): MovieInfo {
        return movieRemoteRepository.getMovieInfo(movieId, language).toMovieInfo()
    }
}