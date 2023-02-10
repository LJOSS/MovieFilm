package com.example.common

sealed class StateAwareData<T: Any> {

    data class Success<T: Any>(val data: T) : StateAwareData<T>()

    data class Error<T: Any>(val error: ErrorEntity) : StateAwareData<T>()

    companion object {

        fun <T: Any> success(data: T): StateAwareData<T> = Success(data)

        fun <T: Any> error(error: ErrorEntity): StateAwareData<T> = Error(error)
    }
}