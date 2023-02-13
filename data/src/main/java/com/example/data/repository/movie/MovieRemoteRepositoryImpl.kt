package com.example.data.repository.movie

import com.example.data.network.ApiService
import com.example.data.network.entity.MovieDetailsResponse
import com.example.data.network.entity.PagedResponse

class MovieRemoteRepositoryImpl(
    private val apiService: ApiService
) : MovieRemoteRepository {

    override suspend fun getMovieList(
        page: Int,
        language: String
    ): PagedResponse =
        apiService.getMovieList(page, language)

    override suspend fun getMovieInfo(
        movieId: Long,
        language: String
    ): MovieDetailsResponse =
        apiService.getMovieInfo(movieId, language)
}