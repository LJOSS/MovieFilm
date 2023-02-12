package com.example.data.repository.movie

import com.example.data.network.dto.MovieDetailsResponseDTO
import com.example.data.network.dto.PagedResponseDTO

interface MovieRemoteRepository {

    suspend fun getMovieList(
        page: Int,
        language: String
    ): PagedResponseDTO

    suspend fun getMovieInfo(
        movieId: Long,
        language: String
    ): MovieDetailsResponseDTO

}