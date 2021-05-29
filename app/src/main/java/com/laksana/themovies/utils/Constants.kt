package com.laksana.themovies.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.laksana.themovies.R

object Constants {

    const val IMAGE_ENDPOINT = "https:/image.tmdb.org/t/p/"
    const val POSTER_SIZE_W185 = "w185"
    const val POSTER_SIZE_W780 = "w780"

    fun setImage(context: Context, poster: String, imgDetailPoster: ImageView) {
        Glide.with(context).load(poster)
            .placeholder(R.drawable.ic_baseline_movie_24)
            .error(R.drawable.ic_baseline_error_outline_24)
            .into(imgDetailPoster)
    }
}