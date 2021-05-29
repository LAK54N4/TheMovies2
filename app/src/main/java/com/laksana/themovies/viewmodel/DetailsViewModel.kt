package com.laksana.themovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.laksana.themovies.data.source.remote.MovieRepository
import com.laksana.themovies.model.MovieDetailModel
import com.laksana.themovies.model.TvShowDetailModel

class DetailsViewModel(private var movieRepository: MovieRepository): ViewModel() {

    fun getDetailMovie(movieId: Int): LiveData<MovieDetailModel> {
        return movieRepository.getMovieDetail(movieId)
    }

    fun getDetailTvShow(movieId: Int): LiveData<TvShowDetailModel> {
        return movieRepository.getTvShowDetail(movieId)
    }

}