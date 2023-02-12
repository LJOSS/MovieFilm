package com.example.common

import android.util.Log
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class UseCase<in Params, out ResultType> where Params : Any {

    protected abstract suspend fun executeOnBackground(params: Params): ResultType

    open suspend operator fun invoke(params: Params): Either<Exception, ResultType> {
        return runCatching {
            try {
                withContext(Dispatchers.Default) { executeOnBackground(params) }
            } catch (e: Exception) {
                if (e !is CancellationException) {
                    Log.e("UseCase Exception", "${e.stackTrace}")
                    Log.e("UseCase Exception", "${e.localizedMessage}")
                    Log.e("UseCase Exception", "${e}")
                }
                throw e
            }
        }
    }
}