package com.example.findnerds.movieapitask.FInal.backend

import android.app.Application
import com.example.findnerds.movieapitask.FInal.di.components.AppComponent
import com.example.findnerds.movieapitask.FInal.di.components.DaggerAppComponent
import com.example.findnerds.movieapitask.FInal.di.modules.ApplicationContextModule
import timber.log.Timber

class MyCustomApplicationClass : Application() {

    private lateinit var applicationComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        applicationComponent = DaggerAppComponent
            .builder()
            .applicationContextModule(ApplicationContextModule(this))
            .build()
    }

    fun getAppComponent() = applicationComponent
}