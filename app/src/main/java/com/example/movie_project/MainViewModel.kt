package com.example.movie_project

import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.common.getOrThrow
import com.example.movie_project.domain.usecase.GetMovieInfoUseCase
import com.example.movie_project.domain.usecase.GetMovieListUseCase
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(
    private val getMovieListUseCase: GetMovieListUseCase,
    private val getMovieInfoUseCase: GetMovieInfoUseCase,
) : BaseViewModel() {

    fun getServices() {
        viewModelScope.launch {
            val q = getMovieInfoUseCase.invoke(GetMovieInfoUseCase.MovieParams(843794)).getOrThrow()
            val w = getMovieListUseCase.invoke(GetMovieListUseCase.MovieParams(1)).getOrThrow()
        }
    }
}