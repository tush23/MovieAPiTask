
package com.example.findnerds.movieapitask.FInal.util

import com.example.findnerds.movieapitask.FInal.response.Result.*
import java.io.IOException
import java.lang.Exception

suspend fun <T : Any> safeApiCall(call: suspend () -> com.example.findnerds.movieapitask.FInal.response.Result<T>, errorMessage: String): com.example.findnerds.movieapitask.FInal.response.Result<T> = try {
    call.invoke()
} catch (e: Exception) {
    Error(IOException(errorMessage, e))
}

val <T> T.exhaustive: T get() = this