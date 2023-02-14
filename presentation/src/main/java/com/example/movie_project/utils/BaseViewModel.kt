package com.example.movie_project.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel : ViewModel() {

    protected val _showProgress = MutableStateFlow(false)
    val showProgress: Flow<Boolean>
        get() = _showProgress.asStateFlow()

    protected val _showError = MutableStateFlow<Throwable?>(null)
    val showError: Flow<Throwable?>
        get() = _showError.asSharedFlow()
}