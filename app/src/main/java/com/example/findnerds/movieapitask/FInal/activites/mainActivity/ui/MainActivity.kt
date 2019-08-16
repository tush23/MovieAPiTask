package com.example.findnerds.movieapitask.FInal.activites.mainActivity.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.findnerds.movieapitask.FInal.activites.BaseActivity
import com.example.findnerds.movieapitask.FInal.activites.mainActivity.di.DaggerMainActivityComponent
import com.example.findnerds.movieapitask.FInal.activites.mainActivity.di.MainActivityModule
import com.example.findnerds.movieapitask.FInal.activites.mainActivity.viewModel.MainActivityViewModel
import com.example.findnerds.movieapitask.FInal.adapter.MovieAdapter
import com.example.findnerds.movieapitask.FInal.response.MovieResponse
import com.example.findnerds.movieapitask.FInal.util.nonNull
import com.example.findnerds.movieapitask.FInal.util.observe
import com.example.findnerds.movieapitask.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    private lateinit var movieAdapter: MovieAdapter
    private val movies = mutableListOf<MovieResponse.Movie>()

    @Inject
    lateinit var picasso: Picasso
    @Inject
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainActivityComponent.builder()
            .mainActivityModule(MainActivityModule(this@MainActivity))
            .appComponent(getAppComponent())
            .build()
            .inject(this@MainActivity)
        val manger = LinearLayoutManager(this)
        moviesRecyclerView.layoutManager = manger
        movieAdapter = MovieAdapter(this, movies, picasso)
        moviesRecyclerView.adapter = movieAdapter
        startListeningToNewMovies()
        listenToErrors()
    }

    private fun startListeningToNewMovies() {
        viewModel
            .movies
            .nonNull()
            .observe(this) {
                progressBar.visibility = View.GONE
                this.movies.addAll(it)
                movieAdapter.notifyDataSetChanged()
            }
    }


    private fun listenToErrors() {
        viewModel.error
            .nonNull()
            .observe(this) {
                progressBar.visibility = View.GONE
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
    }
}
