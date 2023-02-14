package com.example.presentation.presentation.movie_detail

import androidx.lifecycle.viewModelScope
import com.example.presentation.utils.BaseViewModel
import com.example.presentation.usecase.GetMovieInfoUseCase
import com.example.presentation.presentation.entity.MovieInfoUI
import com.example.presentation.presentation.entity.RatingUI
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
        _showProgress.tryEmit(false)
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
            RatingUI(),
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