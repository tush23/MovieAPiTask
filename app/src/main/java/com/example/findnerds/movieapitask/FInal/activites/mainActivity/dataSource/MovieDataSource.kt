package com.example.findnerds.movieapitask.FInal.activites.mainActivity.dataSource

import com.example.findnerds.movieapitask.FInal.response.MovieResponse
import com.example.findnerds.movieapitask.FInal.util.safeApiCall
import com.example.findnerds.movieapitask.FInal.backend.ApiService
import java.io.IOException

@Suppress("EXPERIMENTAL_FEATURE_WARNING")
class MovieDataSource constructor(private val apiService: ApiService) {

    companion object {
        private const val API_KEY = "668135bda25e0f94b5bd4d8fa64c85cb"
    }

    suspend fun getMovies(pageNumber: Int) = safeApiCall(
        call = { upComingMovies(pageNumber) },
        errorMessage = "Error occurred"
    )

    private suspend fun upComingMovies(pageNumber: Int): com.example.findnerds.movieapitask.FInal.response.Result<MovieResponse> {
        val response = apiService.getPopular(apiKey = API_KEY,Mlanguage = "en-US" ,page = pageNumber).await()
        if (response.isSuccessful)
            return com.example.findnerds.movieapitask.FInal.response.Result.Success(response.body()!!)
        return com.example.findnerds.movieapitask.FInal.response.Result.Error(IOException("Error occurred during fetching movies!"))
    }
}
