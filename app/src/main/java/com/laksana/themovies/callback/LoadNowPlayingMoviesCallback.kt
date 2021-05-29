package com.laksana.themovies.callback

import com.laksana.themovies.data.source.remote.response.ResultsItem


interface LoadNowPlayingMoviesCallback {
    fun onAllMoviesReceived(movieResponse: List<ResultsItem>)
}

