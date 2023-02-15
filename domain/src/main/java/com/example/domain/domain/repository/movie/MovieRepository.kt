package com.example.domain.domain.repository.movie

import com.example.domain.domain.entity.MovieInfo
import com.example.domain.domain.entity.MoviePagedInfo

interface MovieRepository {

    suspend fun getMovieList(page: Int): MoviePagedInfo

    suspend fun getMovieInfo(movieId: Long): MovieInfo
}
