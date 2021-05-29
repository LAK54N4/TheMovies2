package com.laksana.themovies.data.source.remote

import com.laksana.themovies.callback.LoadMovieDetailsCallback
import com.laksana.themovies.callback.LoadNowPlayingMoviesCallback
import com.laksana.themovies.callback.LoadTvShowCallback
import com.laksana.themovies.callback.LoadTvShowDetailCallback
import com.laksana.themovies.data.source.remote.apiservice.ApiClient
import com.laksana.themovies.utils.EspressoIdlingResource
import retrofit2.await

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    suspend fun getNowPlayingMovies(callback: LoadNowPlayingMoviesCallback) {
        EspressoIdlingResource.increment()
        ApiClient.instance.getNowPlayingMovies().await().results.let { listMovie ->
            callback.onAllMoviesReceived(
                listMovie
            )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShow(callback: LoadTvShowCallback) {
        EspressoIdlingResource.increment()
        ApiClient.instance.getTvShow().await().results.let { listTvShow ->
           callback.onTvShowsReceived(
               listTvShow
           )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getMoviesDetail(movieId: Int, callback: LoadMovieDetailsCallback) {
        EspressoIdlingResource.increment()
        ApiClient.instance.getMovieDetails(movieId).await().let { movie ->
            callback.onMovieDetailReceived(
                movie
            )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShowDetail(tvShowId: Int, callback: LoadTvShowDetailCallback) {
        EspressoIdlingResource.increment()
        ApiClient.instance.getDetailTvShow(tvShowId).await().let { tvShow ->
            callback.onTvShowDetailReceived(
                tvShow
            )
            EspressoIdlingResource.decrement()
        }
    }
}
