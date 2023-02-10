package com.example.data

import android.util.Log
import com.example.common.ErrorEntity
import com.example.common.StateAwareData
import retrofit2.HttpException
import retrofit2.Response
import java.net.UnknownHostException

class ResponseHandler {

    companion object {
        private const val HTTP_ERROR_400 = 400
        private const val HTTP_ERROR_401 = 401
        const val HTTP_ERROR_500 = 500

        const val HTTP_UNAUTHORIZED = HTTP_ERROR_401
    }

    fun <T, R : Any> handleSuccess(data: Response<T>, mapAction: T.() -> R): StateAwareData<R> =
        if (data.code() == 200) {
            StateAwareData.success(mapAction.invoke(data.body()!!))
        } else {
            StateAwareData.error(getError(data.code()))
        }

    open fun getError(code: Int): ErrorEntity =
        when {
            code == HTTP_ERROR_401 -> {
                ErrorEntity.Unauthorized
            }
            code == HTTP_ERROR_400 -> ErrorEntity.BadRequest
            code >= HTTP_ERROR_500 -> ErrorEntity.ServerError
            else -> ErrorEntity.Fault(code.toString())
        }

    fun handleException(t: Throwable): ErrorEntity =
        when (t) {
            !is Exception -> {
                ErrorEntity.ServiceError
            }
            is HttpException -> getError(t.code())
            is UnknownHostException -> ErrorEntity.Network
            else -> {
                Log.e("NetworkException", "${t.message}")
                Log.e("NetworkException", "${t.localizedMessage}")
                Log.e("NetworkException", "${t.printStackTrace()}")
                Log.e("NetworkException", "${t.cause}")
                ErrorEntity.ServiceError
            }
        }
}