package com.example.movie_project.domain.usecase

import com.example.common.UseCase
import com.example.movie_project.domain.entity.MovieInfo
import com.example.movie_project.domain.mapper.RatingMapper
import com.example.movie_project.domain.repository.confuguration.ConfigurationRepository
import com.example.movie_project.domain.repository.movie.MovieRepository
import com.example.movie_project.presentation.entity.MovieInfoUI
import com.example.movie_project.presentation.entity.RatingUI

class GetMovieInfoUseCase(
    private val movieRepository: MovieRepository,
    private val getConfigurationRepository: ConfigurationRepository,
    private val ratingMapper: RatingMapper,
) : UseCase<GetMovieInfoUseCase.MovieParams, MovieInfoUI>() {

    override suspend fun executeOnBackground(params: MovieParams): MovieInfoUI {
        val movieInfo: MovieInfo = movieRepository.getMovieInfo(params.movieId)

        return MovieInfoUI(
            movieInfo.isAdult,
            movieInfo.backDropPath,
            movieInfo.budget,
            movieInfo.genres.map { it.name }.joinToString { "$it" },
            movieInfo.homepage,
            movieInfo.id,
            movieInfo.originalTitle,
            movieInfo.overview,
            "${getConfigurationRepository.getOriginalImageBaseUrl()}${movieInfo.posterPath}",
            movieInfo.releaseDate,
            movieInfo.status,
            movieInfo.tagline,
            movieInfo.title,
            movieInfo.isVideo,
            RatingUI(movieInfo.voteAverage, ratingMapper.getRatingColor(movieInfo.voteAverage)),
            movieInfo.voteCount,
        )
    }

    data class MovieParams(
        val movieId: Long
    )
}