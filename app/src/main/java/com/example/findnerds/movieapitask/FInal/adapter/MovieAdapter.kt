package com.example.findnerds.movieapitask.FInal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.findnerds.movieapitask.FInal.response.MovieResponse
import com.example.findnerds.movieapitask.FInal.viewHolder.MovieViewHolder
import com.example.findnerds.movieapitask.R
import com.squareup.picasso.Picasso

class MovieAdapter constructor(
    context: Context,
    private val movies: List<MovieResponse.Movie>,
    picasso: Picasso
) :
    RecyclerView.Adapter<MovieViewHolder>() {

    companion object {
        const val IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w185"
    }

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder =
        MovieViewHolder(layoutInflater.inflate(R.layout.top_rated_fragment, p0, false))

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        val url = IMAGE_BASE_URL.plus(movie.poster_path)
        Picasso.get().load(url).into(holder.moviePosterImageView)
        holder.movieRealeseDateTextView.text = movie.release_date
        holder.movieTitleTextView.text = movie.title
        holder.movieOverTextView.text = movie.overview

    }
}