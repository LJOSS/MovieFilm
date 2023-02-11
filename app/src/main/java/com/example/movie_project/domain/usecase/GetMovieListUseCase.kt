package com.example.movie_project.domain.usecase

import com.example.common.UseCase
import com.example.movie_project.domain.entity.MoviePagedInfo
import com.example.movie_project.domain.repository.confuguration.ConfigurationRepository
import com.example.movie_project.domain.repository.movie.MovieRepository

class GetMovieListUseCase(
    private val movieRepository: MovieRepository,
    private val getConfigurationRepository: ConfigurationRepository
) : UseCase<GetMovieListUseCase.MovieParams, MoviePagedInfo>() {

    override suspend fun executeOnBackground(params: MovieParams): MoviePagedInfo {
        val moviePagedInfo = movieRepository.getMovieList(params.page)
        return moviePagedInfo.copy(
            results = moviePagedInfo.results
                .map { movie ->
                    return@map movie.copy(
                        posterUrl = "${getConfigurationRepository.getPosterImageBaseUrl()}${movie.posterUrl}"
                    )
                }
        )
    }

    data class MovieParams(
        val page: Int
    )
}