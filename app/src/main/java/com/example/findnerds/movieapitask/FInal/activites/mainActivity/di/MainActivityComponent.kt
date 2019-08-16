package com.example.findnerds.movieapitask.FInal.activites.mainActivity.di

import com.example.findnerds.movieapitask.FInal.activites.mainActivity.ui.MainActivity
import com.example.findnerds.movieapitask.FInal.activites.mainActivity.viewModel.MainActivityViewModel
import com.example.findnerds.movieapitask.FInal.di.components.AppComponent
import dagger.Component

@MainActivityScope
@Component(modules = [MainActivityModule::class], dependencies = [AppComponent::class])
interface MainActivityComponent : AppComponent {

    fun inject(mainActivity: MainActivity)

    fun viewModel(): MainActivityViewModel
}