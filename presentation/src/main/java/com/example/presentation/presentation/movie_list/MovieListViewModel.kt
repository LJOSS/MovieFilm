package com.example.presentation.presentation.movie_list

import androidx.lifecycle.viewModelScope
import com.example.presentation.presentation.entity.MoviePagedInfoUI
import com.example.presentation.presentation.entity.MovieUI
import com.example.presentation.usecase.GetMovieListUseCase
import com.example.presentation.utils.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val getMovieListUseCase: GetMovieListUseCase
) : BaseViewModel() {

    private val _data = MutableStateFlow(MoviePagedInfoUI())

    val data: Flow<List<MovieUI>>
        get() = _data.map { it.results }

    private val _isLoading = MutableSharedFlow<Boolean>(replay = 1)
    val isLoading: Flow<Boolean>
        get() = _isLoading.asSharedFlow()

    private val _onSelectMovie = MutableSharedFlow<Long>()
    val onSelectMovie: Flow<Long>
        get() = _onSelectMovie.asSharedFlow()

    private val _page = MutableStateFlow(1)

    private var _job: Job? = null

    init {
        onLoad(false)
    }

    fun onItemClicked(movie: MovieUI) {
        viewModelScope.launch {
            _onSelectMovie.emit(movie.id)
        }
    }

    fun onLoad(refresh: Boolean) {
        _job?.cancel()

        _showProgress.value = true

        if (refresh) {
            _data.value = MoviePagedInfoUI()
            _page.value = 1
        }

        _job = _page.flatMapLatest { getMovies(it) }
            .onEach { moviePagedInfo ->
                val data = _data.value.results.toMutableList()
                data.addAll(moviePagedInfo.results)
                _data.value = moviePagedInfo.copy(results = data)

                _showProgress.value = false

                _isLoading.emit(false)
            }
            .catch {
                // TODO HTTP 422 out of list
                _showProgress.value = false
                _showError.value = it
            }
            .launchIn(viewModelScope)
    }

    private fun getMovies(
        page: Int = 1
    ): Flow<MoviePagedInfoUI> {
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
        _showProgress.value = true
        _isLoading.tryEmit(true)

        _page.value = _data.value.page.inc()
    }
}
