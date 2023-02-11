package com.example.data.repository.movie

import com.example.data.network.dto.MovieDetailsResponseDTO
import com.example.data.network.dto.PagedResponseDTO

interface MovieRemoteRepository {

    suspend fun getMovieList(
        page: Int,
        language: String = "en"
    ): PagedResponseDTO

    suspend fun getMovieInfo(
        movieId: Long,
        language: String = "en"
    ): MovieDetailsResponseDTO

}