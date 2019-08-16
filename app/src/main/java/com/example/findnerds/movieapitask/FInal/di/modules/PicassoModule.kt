package com.example.findnerds.movieapitask.FInal.di.modules

import android.content.Context
import com.example.findnerds.movieapitask.FInal.di.qualifiers.ApplicationContextQualifier
import com.example.findnerds.movieapitask.FInal.di.scopes.CustomApplicationScope
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module(includes = [NetworkModule::class])
class PicassoModule {

    @Provides
    @CustomApplicationScope
    fun getOkHttp3Downloader(okHttpClient: OkHttpClient) = OkHttp3Downloader(okHttpClient)

    @Provides
    @CustomApplicationScope
    fun getPicasso(@ApplicationContextQualifier context: Context, okHttpDownloader: OkHttp3Downloader): Picasso {
        return Picasso.Builder(context)
            .downloader(okHttpDownloader)
            .build()
    }
}
