package com.example.findnerds.movieapitask.FInal.di.components

import com.example.findnerds.movieapitask.FInal.backend.ApiService
import com.example.findnerds.movieapitask.FInal.di.scopes.CustomApplicationScope
import com.example.findnerds.movieapitask.FInal.di.modules.PicassoModule
import com.example.findnerds.movieapitask.FInal.di.modules.ServiceUtilModule
import com.squareup.picasso.Picasso
import dagger.Component

@CustomApplicationScope
@Component(modules = [PicassoModule::class, ServiceUtilModule::class])
interface AppComponent {

    fun getPicasso(): Picasso

    fun getApiService(): ApiService
}
