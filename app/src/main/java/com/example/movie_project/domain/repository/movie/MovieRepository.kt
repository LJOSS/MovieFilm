package com.example.movie_project.domain.repository.movie

import com.example.movie_project.domain.entity.MovieInfo
import com.example.movie_project.domain.entity.MoviePagedInfo

interface MovieRepository {

    suspend fun getMovieList(page: Int): MoviePagedInfo

    suspend fun getMovieInfo(movieId: Long): MovieInfo

}