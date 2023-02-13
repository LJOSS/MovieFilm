package com.example.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class UseCase<in Params, out ResultType> where Params : Any {

    protected abstract suspend fun executeOnBackground(params: Params): ResultType

    open suspend operator fun invoke(params: Params): Result<ResultType> {
        return Result.success(withContext(Dispatchers.Default) { executeOnBackground(params) })
    }
}