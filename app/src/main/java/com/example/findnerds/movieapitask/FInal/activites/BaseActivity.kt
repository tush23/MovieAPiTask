package com.example.findnerds.movieapitask.FInal.activites

import androidx.appcompat.app.AppCompatActivity
import com.example.findnerds.movieapitask.FInal.backend.MyCustomApplicationClass

open class BaseActivity : AppCompatActivity() {

    protected fun getAppComponent() = getApp().getAppComponent()

    private fun getApp() = this.applicationContext as MyCustomApplicationClass
}