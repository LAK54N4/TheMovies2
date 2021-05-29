package com.laksana.themovies.dependencyinjection

import com.laksana.themovies.data.source.remote.MovieRepository
import com.laksana.themovies.data.source.remote.RemoteDataSource

object Injection {
    fun provideMovieRepository(): MovieRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return MovieRepository.getInstance(remoteDataSource)
    }
}


