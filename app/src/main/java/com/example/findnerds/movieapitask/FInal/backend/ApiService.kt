package com.example.findnerds.movieapitask.FInal.backend

import com.example.findnerds.movieapitask.FInal.response.MovieResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(value = "upcoming")
    fun getPopular(
        @Query(
            value = "api_key"
        ) apiKey: String,
        @Query(
            value = "language"
        )Mlanguage:String,
        @Query(
            value = "page"
        ) page: Int
    ): Deferred<Response<MovieResponse>>
}