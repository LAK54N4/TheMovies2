package com.laksana.themovies.callback

import com.laksana.themovies.data.source.remote.response.TvShowDetailsResponse

interface LoadTvShowDetailCallback {
    fun onTvShowDetailReceived(tvShowDetailResponse: TvShowDetailsResponse)
}

