package com.example.movie_project.presentation.movie_detail

import androidx.lifecycle.ViewModel
import com.example.movie_project.domain.usecase.GetMovieInfoUseCase

class MovieDetailViewModel(
    private val getMovieInfoUseCase: GetMovieInfoUseCase
) : ViewModel() {

}