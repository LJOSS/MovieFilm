package com.example.data.repository.movie

import com.example.data.network.entity.MovieDetailsResponse
import com.example.data.network.entity.PagedResponse

interface MovieRemoteRepository {

    suspend fun getMovieList(
        page: Int,
        language: String
    ): PagedResponse

    suspend fun getMovieInfo(
        movieId: Long,
        language: String
    ): MovieDetailsResponse
}
