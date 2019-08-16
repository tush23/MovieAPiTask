package com.example.findnerds.movieapitask.FInal.viewHolder
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.findnerds.movieapitask.R

class MovieViewHolder (itemView1: View) : RecyclerView.ViewHolder(itemView1) {

    val moviePosterImageView: ImageView = itemView1.findViewById(R.id.poster_img)
    val movieLanTextView: TextView = itemView1.findViewById(R.id.lang_id)
    val movieTitleTextView: TextView = itemView1.findViewById(R.id.movie_title)
    val movieRealeseDateTextView: TextView = itemView1.findViewById(R.id.release_date)
    val movieOverTextView: TextView = itemView1.findViewById(R.id.overview)

}