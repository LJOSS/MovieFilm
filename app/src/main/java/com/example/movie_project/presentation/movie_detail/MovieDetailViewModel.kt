package com.example.movie_project.presentation.movie_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.getOrThrow
import com.example.movie_project.domain.usecase.GetMovieInfoUseCase
import com.example.movie_project.presentation.entity.MovieInfoUI
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val movieId: Long,
    private val getMovieInfoUseCase: GetMovieInfoUseCase
) : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->

    }

    private val _data = MutableSharedFlow<MovieInfoUI>()
    val data: Flow<MovieInfoUI>
        get() = _data.asSharedFlow()

    init {
        onLoad()
    }

    private fun onLoad() {
        viewModelScope.launch(exceptionHandler) {
            _data.emit(
                getMovieInfoUseCase.invoke(GetMovieInfoUseCase.MovieParams(movieId)).getOrThrow()
            )
        }
    }
}