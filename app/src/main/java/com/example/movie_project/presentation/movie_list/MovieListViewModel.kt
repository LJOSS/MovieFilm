package com.example.movie_project.presentation.movie_list

import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.common.getOrThrow
import com.example.movie_project.domain.entity.Movie
import com.example.movie_project.domain.usecase.GetMovieListUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val getMovieListUseCase: GetMovieListUseCase
) : BaseViewModel() {

    private val _data = MutableStateFlow<List<Movie>>(emptyList())
    val data: Flow<List<Movie>>
        get() = _data.asStateFlow()

    init {
        onLoad()
    }

    fun onItemClicked(movie: Movie) {

    }

    private fun onLoad() {
        viewModelScope.launch {
            val q = getMovieListUseCase.invoke(GetMovieListUseCase.MovieParams(1)).getOrThrow()
            _data.emit(q.results)
        }
    }
}