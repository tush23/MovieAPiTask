package com.example.findnerds.movieapitask.FInal.di.modules

import android.content.Context
import com.example.findnerds.movieapitask.FInal.di.qualifiers.ApplicationContextQualifier
import com.example.findnerds.movieapitask.FInal.di.scopes.CustomApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ApplicationContextModule(private var context: Context) {

    @Provides
    @CustomApplicationScope
    @ApplicationContextQualifier
    fun getContext() = context
}
