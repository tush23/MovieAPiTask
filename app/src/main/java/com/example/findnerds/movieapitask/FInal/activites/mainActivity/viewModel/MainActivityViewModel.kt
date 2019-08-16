package com.example.findnerds.movieapitask.FInal.activites.mainActivity.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.findnerds.movieapitask.FInal.activites.mainActivity.dataSource.MovieDataSource
import com.example.findnerds.movieapitask.FInal.response.MovieResponse
import com.example.findnerds.movieapitask.FInal.response.Result
import com.example.findnerds.movieapitask.FInal.util.NonNullMediatorLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext


class MainActivityViewModel constructor(private val movieDataSource: MovieDataSource) : ViewModel() {

    private val _movies = NonNullMediatorLiveData<List<MovieResponse.Movie>>()
    private val _error = NonNullMediatorLiveData<String>()

    private var moviesJob: Job? = null

    val movies: LiveData<List<MovieResponse.Movie>> get() = _movies
    val error: LiveData<String> get() = _error



    init {
        initGetMoviesCall()
    }

    private fun initGetMoviesCall() {
        moviesJob = CoroutineScope(context =EmptyCoroutineContext ).launch  {
            when (val value = movieDataSource.getMovies(1)) {
                is Result.Success -> _movies.postValue(value.data.movies)
                is Result.Error -> _error.postValue(value.exception.message)
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        moviesJob?.cancel()
    }
    fun main(args: Array<String>) {

    }
}
