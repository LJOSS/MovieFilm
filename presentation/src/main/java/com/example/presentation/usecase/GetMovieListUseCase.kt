package com.example.presentation.usecase

import com.example.domain.domain.mapper.DateMapper
import com.example.domain.domain.mapper.RatingMapper
import com.example.domain.domain.repository.confuguration.ConfigurationRepositoryApi
import com.example.domain.domain.repository.genre.GenreRepositoryApi
import com.example.domain.domain.repository.movie.MovieRepositoryApi
import com.example.presentation.presentation.entity.MoviePagedInfoUI
import com.example.presentation.presentation.entity.MovieUI
import com.example.presentation.presentation.entity.RatingColoredUI
import com.example.presentation.presentation.entity.RatingUI
import com.example.presentation.utils.UseCase

class GetMovieListUseCase(
    private val movieRepositoryApi: MovieRepositoryApi,
    private val getConfigurationRepositoryApi: ConfigurationRepositoryApi,
    private val getGenreRepositoryApi: GenreRepositoryApi,
    private val ratingMapper: RatingMapper,
    private val dateMapper: DateMapper
) : UseCase<GetMovieListUseCase.MovieParams, MoviePagedInfoUI>() {

    override suspend fun executeOnBackground(params: MovieParams): MoviePagedInfoUI {
        val moviePagedInfo = movieRepositoryApi.getMovieList(params.page)

        return MoviePagedInfoUI(
            moviePagedInfo.page,
            moviePagedInfo.results.map {
                val ratingUI =
                    RatingColoredUI.getRatingUIById(ratingMapper.getRatingColor(it.rating))

                MovieUI(
                    id = it.id,
                    posterUrl = "${getConfigurationRepositoryApi.getPosterImageBaseUrl()}${it.posterUrl}",
                    rating = RatingUI(it.rating, ratingUI.ratingColor),
                    voteCount = it.voteCount,
                    title = it.originalTitle,
                    originalTitle = it.title,
                    date = dateMapper.mapToYYYYMM(it.date),
                    genres = getGenreRepositoryApi.getListOfGenreById(it.genres)
                        .joinToString { "$it" }
                )
            }
        )
    }

    data class MovieParams(
        val page: Int
    )
}
