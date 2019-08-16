package com.example.findnerds.movieapitask.FInal.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.example.findnerds.movieapitask.FInal.backend.ApiService
import com.example.findnerds.movieapitask.FInal.di.scopes.CustomApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module(includes = [NetworkModule::class])
class ServiceUtilModule {

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/movie/"
    }

    @Provides
    @CustomApplicationScope
    fun getServiceUtil(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @CustomApplicationScope
    fun getGson() = GsonBuilder().create()!!

    @Provides
    @CustomApplicationScope
    fun getRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
    }
}