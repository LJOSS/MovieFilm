package com.example.data.repository.movie

import com.example.data.ResponseHandler
import com.example.data.network.APIService
import com.example.data.network.dto.MovieDetailsResponseDTO
import com.example.data.network.dto.PagedResponseDTO

class MovieRemoteRepositoryImpl(
    private val apiService: APIService,
    private val responseHandler: ResponseHandler
) : MovieRemoteRepository {

    override suspend fun getMovieList(
        page: Int,
        language: String
    ): PagedResponseDTO =
        apiService.getMovieList(page, language)

    override suspend fun getMovieInfo(
        movieId: Long,
        language: String
    ): MovieDetailsResponseDTO =
        apiService.getMovieInfo(movieId, language)
}