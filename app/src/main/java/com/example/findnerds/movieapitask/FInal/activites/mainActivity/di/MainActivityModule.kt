package com.example.findnerds.movieapitask.FInal.activites.mainActivity.di

import androidx.lifecycle.ViewModelProviders
import com.example.findnerds.movieapitask.FInal.activites.mainActivity.dataSource.MovieDataSource
import com.example.findnerds.movieapitask.FInal.activites.mainActivity.ui.MainActivity
import com.example.findnerds.movieapitask.FInal.activites.mainActivity.viewModel.MainActivityViewModel
import com.example.findnerds.movieapitask.FInal.activites.mainActivity.viewModel.MainActivityViewModelFactory
import com.example.findnerds.movieapitask.FInal.backend.ApiService
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule constructor(private val mainActivity: MainActivity) {

    @Provides
    @MainActivityScope
    fun movieDataSource(apiService: ApiService) = MovieDataSource(apiService)

    @Provides
    @MainActivityScope
    fun mainActivityViewModelFactory(movieDataSource: MovieDataSource) = MainActivityViewModelFactory(movieDataSource)

    @Provides
    @MainActivityScope
    fun mainActivityViewModel(viewModelFactory: MainActivityViewModelFactory): MainActivityViewModel =
        ViewModelProviders.of(mainActivity, viewModelFactory).get(MainActivityViewModel::class.java)
}