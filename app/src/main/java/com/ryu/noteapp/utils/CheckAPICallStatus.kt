package com.ryu.noteapp.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import retrofit2.Response

// API call status
sealed class Future<out T> {
    object Proceeding : Future<Nothing>()

    data class Success<out T>(val value: T) : Future<T>()

    data class Failure(val error: Throwable) : Future<Nothing>()
}

inline fun <reified T : Any> apiFlow(crossinline call: suspend () -> Response<T>): Flow<Future<T>> =
    flow<Future<T>> {
       val response = call()

        if (response.isSuccessful) emit(Future.Success(value = response.body()!!))
        else throw HttpException(response)
    }.catch { it: Throwable ->
        emit(Future.Failure(it))
    }.onStart {
        emit(Future.Proceeding)
    }.flowOn(Dispatchers.IO)
