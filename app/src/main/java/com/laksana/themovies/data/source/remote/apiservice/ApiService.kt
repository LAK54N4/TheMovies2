package com.laksana.themovies.data.source.remote.apiservice

import com.laksana.themovies.BuildConfig
import com.laksana.themovies.data.source.remote.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<MovieResponse<ResultsItem>>

    @GET("tv/on_the_air")
    fun getTvShow(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<TvShowResponse<TVShowResultsItem>>

    @GET("movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<MovieDetailsResponse>

    @GET("tv/{tv_id}")
    fun getDetailTvShow(
        @Path("tv_id") tvShowId: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<TvShowDetailsResponse>
}

