package com.example.movie_project.presentation.movie_list

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.common.getOrThrow
import com.example.movie_project.domain.entity.Movie
import com.example.movie_project.domain.entity.MoviePagedInfo
import com.example.movie_project.domain.usecase.GetMovieListUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val getMovieListUseCase: GetMovieListUseCase
) : BaseViewModel() {

    private val _data = MutableStateFlow(MoviePagedInfo())

    val data: Flow<List<Movie>>
        get() = _data.map { it.results }

    private val _isLoading = MutableSharedFlow<Boolean>(replay = 1)
    val isLoading: Flow<Boolean>
        get() = _isLoading.asSharedFlow()

    private val _onSelectMovie = MutableSharedFlow<Long>()
    val onSelectMovie: Flow<Long>
        get() = _onSelectMovie.asSharedFlow()

    private val _offset = MutableStateFlow(1)

    private var _job: Job? = null

    init {
        onLoad(false)
    }

    fun onItemClicked(movie: Movie) {
        viewModelScope.launch {
            _onSelectMovie.emit(movie.id)
        }
    }

    fun onLoad(refresh: Boolean) {
        _job?.cancel()

        if (refresh) {
            _data.value = MoviePagedInfo()
            _offset.value = 1
        }

        _job = _offset.flatMapLatest { getMovies(it) }
            .onEach { moviePagedInfo ->
                val data = _data.value.results.toMutableList()
                data.addAll(moviePagedInfo.results)
                _data.value = moviePagedInfo.copy(results = data)

                _showProgress.value = false

                _isLoading.emit(false)
            }
            .catch {
                //TODO HTTP 422 out of list
                _showProgress.value = false
                _showError.value = it
            }
            .launchIn(viewModelScope)
    }

    private fun getMovies(
        page: Int = 1,
    ): Flow<MoviePagedInfo> {
        return channelFlow {

            val params = GetMovieListUseCase.MovieParams(page)

            if (!isActive) {
                return@channelFlow
            }

            val moviePagedInfo = getMovieListUseCase.invoke(params).getOrThrow()
            send(moviePagedInfo)
        }
    }

    fun onLoadMore() {
        _isLoading.tryEmit(true)
        Log.d("onLoadMore", "onLoadMore ${_offset.value} - ${_data.value.page}")
        _offset.value = _data.value.page.inc()
    }
}