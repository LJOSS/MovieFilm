package com.example.movie_project.domain.repository

import com.example.movie_project.domain.entity.MovieInfo
import com.example.movie_project.domain.entity.MoviePagedInfo

interface MovieRemoteRepository {

    suspend fun getMovieList(
        page: Int,
        language: String = "en"
    ): MoviePagedInfo

    suspend fun getMovieInfo(
        movieId: Long,
        language: String = "en"
    ): MovieInfo

}