package com.laksana.themovies.data.source

import androidx.lifecycle.LiveData
import com.laksana.themovies.model.DataModel
import com.laksana.themovies.model.MovieDetailModel
import com.laksana.themovies.model.TvShowDetailModel
import com.laksana.themovies.model.TvShowModel

interface MovieDataSource {
    fun getNowPlayingMovies(): LiveData<List<DataModel>>

    fun getTvShow(): LiveData<List<TvShowModel>>

    fun getMovieDetail(movieId: Int): LiveData<MovieDetailModel>

    fun getTvShowDetail(tvShowId: Int): LiveData<TvShowDetailModel>
}

