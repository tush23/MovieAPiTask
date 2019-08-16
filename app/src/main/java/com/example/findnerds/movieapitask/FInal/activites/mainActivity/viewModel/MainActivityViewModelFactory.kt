package com.example.findnerds.movieapitask.FInal.activites.mainActivity.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.findnerds.movieapitask.FInal.activites.mainActivity.dataSource.MovieDataSource

@Suppress("UNCHECKED_CAST")
class MainActivityViewModelFactory constructor(private val movieDataSource: MovieDataSource) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>) = MainActivityViewModel(movieDataSource) as T
}