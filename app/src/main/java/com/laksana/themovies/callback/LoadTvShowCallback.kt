package com.laksana.themovies.callback

import com.laksana.themovies.data.source.remote.response.TVShowResultsItem

interface LoadTvShowCallback {
    fun onTvShowsReceived(tvShowResponse:List<TVShowResultsItem>)
}
