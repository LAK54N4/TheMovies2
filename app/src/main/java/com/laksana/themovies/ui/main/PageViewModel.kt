package com.laksana.themovies.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.laksana.themovies.data.source.remote.MovieRepository
import com.laksana.themovies.model.DataModel
import com.laksana.themovies.model.TvShowModel

class PageViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getListPlayingMovies(): LiveData<List<DataModel>> {
        return movieRepository.getNowPlayingMovies()
    }

    fun getListTvShows(): LiveData<List<TvShowModel>> {
        return movieRepository.getTvShow()
    }
}