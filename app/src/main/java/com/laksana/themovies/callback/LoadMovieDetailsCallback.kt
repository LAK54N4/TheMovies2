package com.laksana.themovies.callback

import com.laksana.themovies.data.source.remote.response.MovieDetailsResponse

interface LoadMovieDetailsCallback {
    fun onMovieDetailReceived(movieDetailResponse: MovieDetailsResponse)
}
