package com.example.movie_project.presentation.movie_detail

import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.common.getOrThrow
import com.example.movie_project.domain.usecase.GetMovieInfoUseCase
import com.example.movie_project.presentation.entity.MovieInfoUI
import com.example.movie_project.presentation.entity.RatingUI
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val movieId: Long,
    private val getMovieInfoUseCase: GetMovieInfoUseCase
) : BaseViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        _showError.tryEmit(exception)
    }

    private val _data = MutableStateFlow<MovieInfoUI>(
        MovieInfoUI(
            false,
            "",
            "",
            "",
            "",
            -1,
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            false,
            RatingUI(0.0f, 0),
            0
        )
    )

    val data: Flow<MovieInfoUI>
        get() = _data.asSharedFlow()

    init {
        onLoad()
    }

    private fun onLoad() {
        viewModelScope.launch(exceptionHandler) {
            _showProgress.tryEmit(true)
            _data.emit(
                getMovieInfoUseCase.invoke(GetMovieInfoUseCase.MovieParams(movieId)).getOrThrow()
            )
            _showProgress.tryEmit(false)
        }
    }
}