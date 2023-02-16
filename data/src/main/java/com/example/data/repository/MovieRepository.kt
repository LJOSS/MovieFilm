package com.example.data.repository

import com.example.data.network.ApiService
import com.example.data.network.entity.toMovieInfo
import com.example.data.network.entity.toMoviePagedInfo
import com.example.domain.domain.entity.MovieInfo
import com.example.domain.domain.entity.MoviePagedInfo
import com.example.domain.domain.repository.movie.MovieRepositoryApi
import java.util.*

internal class MovieRepository(
    private val apiService: ApiService
) : MovieRepositoryApi {

    override suspend fun getMovieList(page: Int): MoviePagedInfo =
        apiService.getMovieList(page, Locale.getDefault().toLanguageTag()).toMoviePagedInfo()

    override suspend fun getMovieInfo(movieId: Long): MovieInfo =
        apiService.getMovieInfo(movieId, Locale.getDefault().toLanguageTag()).toMovieInfo()
}
