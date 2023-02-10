package com.example.common

sealed class ErrorEntity {
    object Network : ErrorEntity()

    object Timeout : ErrorEntity()

    object ServiceError : ErrorEntity()

    data class Fault(val text: String) : ErrorEntity()

    object Unknown : ErrorEntity()

    object Unauthorized : ErrorEntity()

    object BadRequest : ErrorEntity()

    object ServerError : ErrorEntity()
}