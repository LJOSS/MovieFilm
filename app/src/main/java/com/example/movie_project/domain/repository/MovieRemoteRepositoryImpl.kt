package com.example.movie_project.domain.repository

import com.example.data.repository.MovieRepository
import com.example.movie_project.domain.entity.MovieInfo
import com.example.movie_project.domain.entity.MoviePagedInfo
import com.example.movie_project.domain.entity.toMovieInfo
import com.example.movie_project.domain.entity.toMoviePagedInfo

class MovieRemoteRepositoryImpl(
    private val movieRepository: MovieRepository
) : MovieRemoteRepository {

    override suspend fun getMovieList(page: Int, language: String): MoviePagedInfo {
        return movieRepository.getMovieList(page, language).toMoviePagedInfo()
    }

    override suspend fun getMovieInfo(movieId: Long, language: String): MovieInfo {
        return movieRepository.getMovieInfo(movieId, language).toMovieInfo()
    }
}