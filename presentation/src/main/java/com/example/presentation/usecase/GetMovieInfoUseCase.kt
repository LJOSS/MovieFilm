package com.example.presentation.usecase

import com.example.domain.domain.entity.MovieInfo
import com.example.domain.domain.mapper.BudgetMapper
import com.example.domain.domain.mapper.DateMapper
import com.example.domain.domain.mapper.RatingMapper
import com.example.domain.domain.repository.confuguration.ConfigurationRepositoryApi
import com.example.domain.domain.repository.movie.MovieRepositoryApi
import com.example.presentation.presentation.entity.MovieInfoUI
import com.example.presentation.presentation.entity.RatingColoredUI
import com.example.presentation.presentation.entity.RatingUI
import com.example.presentation.utils.UseCase

class GetMovieInfoUseCase(
    private val movieRepositoryApi: MovieRepositoryApi,
    private val getConfigurationRepositoryApi: ConfigurationRepositoryApi,
    private val ratingMapper: RatingMapper,
    private val dateMapper: DateMapper,
    private val budgetMapper: BudgetMapper
) : UseCase<GetMovieInfoUseCase.MovieParams, MovieInfoUI>() {

    override suspend fun executeOnBackground(params: MovieParams): MovieInfoUI {
        val movieInfo: MovieInfo = movieRepositoryApi.getMovieInfo(params.movieId)

        val ratingUI =
            RatingColoredUI.getRatingUIById(ratingMapper.getRatingColor(movieInfo.voteAverage))

        return MovieInfoUI(
            movieInfo.isAdult,
            movieInfo.backDropPath,
            budgetMapper.mapBudget(movieInfo.budget),
            movieInfo.genres.map { it.name }.joinToString { "$it" },
            movieInfo.homepage,
            movieInfo.id,
            movieInfo.originalTitle,
            movieInfo.overview,
            "${getConfigurationRepositoryApi.getOriginalImageBaseUrl()}${movieInfo.posterPath}",
            dateMapper.mapToYYYYMM(movieInfo.releaseDate),
            movieInfo.status,
            movieInfo.tagline,
            movieInfo.title,
            movieInfo.isVideo,
            RatingUI(movieInfo.voteAverage, ratingUI.ratingColor),
            movieInfo.voteCount
        )
    }

    data class MovieParams(
        val movieId: Long
    )
}
