package com.example.common

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest

abstract class FlowUseCase<in Params, out ResultType> where Params : Any {

    protected abstract fun executeOnBackground(params: Params): Flow<ResultType>

    @Suppress("UNCHECKED_CAST", "NO_CAST_NEEDED")
    open operator fun invoke(params: Params): Flow<Either<Exception, ResultType>> {
        return executeOnBackground(params).flowOn(Dispatchers.IO)
            .mapLatest { Either.Right(it) as Either<Exception, ResultType> }
            .catch { error ->
                Log.e("FlowUseCase Exception", "${error.stackTrace}")
                emit(Either.Left(error) as Either<Exception, ResultType>)
            }
    }
}

object NoParams