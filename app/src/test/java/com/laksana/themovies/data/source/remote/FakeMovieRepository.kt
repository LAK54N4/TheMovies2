package com.laksana.themovies.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.laksana.themovies.callback.LoadMovieDetailsCallback
import com.laksana.themovies.callback.LoadNowPlayingMoviesCallback
import com.laksana.themovies.callback.LoadTvShowCallback
import com.laksana.themovies.callback.LoadTvShowDetailCallback
import com.laksana.themovies.data.source.MovieDataSource
import com.laksana.themovies.data.source.remote.response.MovieDetailsResponse
import com.laksana.themovies.data.source.remote.response.ResultsItem
import com.laksana.themovies.data.source.remote.response.TVShowResultsItem
import com.laksana.themovies.data.source.remote.response.TvShowDetailsResponse
import com.laksana.themovies.model.DataModel
import com.laksana.themovies.model.MovieDetailModel
import com.laksana.themovies.model.TvShowDetailModel
import com.laksana.themovies.model.TvShowModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource): MovieDataSource {
    override fun getNowPlayingMovies(): LiveData<List<DataModel>> {
        val movieResult = MutableLiveData<List<DataModel>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getNowPlayingMovies(object : LoadNowPlayingMoviesCallback {
                override fun onAllMoviesReceived(movieResponse: List<ResultsItem>) {
                    val movieList = ArrayList<DataModel>()
                    for (response in movieResponse) {
                        val movie = DataModel(
                            response.id,
                            response.title,
                            response.overview,
                            response.posterPath,
                            response.releaseDate,
                            response.backdropPath
                        )
                        movieList.add(movie)
                    }
                    movieResult.postValue(movieList)
                }
            })
        }
        return movieResult
    }

    override fun getTvShow(): LiveData<List<TvShowModel>> {
        val resultTvShow = MutableLiveData<List<TvShowModel>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTvShow(object : LoadTvShowCallback {
                override fun onTvShowsReceived(tvShowResponse: List<TVShowResultsItem>) {
                    val listTvShow = ArrayList<TvShowModel>()
                    for (response in tvShowResponse) {
                        val tvShow = TvShowModel(
                            response.id,
                            response.name,
                            response.overview,
                            response.posterPath,
                            response.firstAirDate,
                            response.backdropPath,
                        )
                        listTvShow.add(tvShow)
                    }
                    resultTvShow.postValue(listTvShow)
                }
            })
        }
        return resultTvShow
    }

    override fun getMovieDetail(movieId: Int): LiveData<MovieDetailModel> {
        val resultDetailMovie = MutableLiveData<MovieDetailModel>()
        CoroutineScope(IO).launch {
            remoteDataSource.getMoviesDetail(movieId, object : LoadMovieDetailsCallback {
                override fun onMovieDetailReceived(movieDetailResponse: MovieDetailsResponse) {
                    val movieDetail = MovieDetailModel(
                        movieDetailResponse.id,
                        movieDetailResponse.backdropPath,
                        movieDetailResponse.budget,
                        movieDetailResponse.originalLanguage,
                        movieDetailResponse.title,
                        movieDetailResponse.overview,
                        movieDetailResponse.posterPath,
                        movieDetailResponse.releaseDate,
                        movieDetailResponse.runtime,
                    )
                    resultDetailMovie.postValue(movieDetail)
                }
            })
        }
        return resultDetailMovie
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<TvShowDetailModel> {
        val resultDetailTvShow = MutableLiveData<TvShowDetailModel>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTvShowDetail(tvShowId, object : LoadTvShowDetailCallback {
                override fun onTvShowDetailReceived(tvShowDetailResponse: TvShowDetailsResponse) {
                    val tvShow = TvShowDetailModel(
                        tvShowDetailResponse.id,
                        tvShowDetailResponse.backdropPath,
                        tvShowDetailResponse.originalLanguages,
                        tvShowDetailResponse.name,
                        tvShowDetailResponse.overview,
                        tvShowDetailResponse.posterPath,
                        tvShowDetailResponse.firstAirDate,
                        tvShowDetailResponse.numberOfEpisodes,
                        tvShowDetailResponse.numberOfSeasons
                    )
                    resultDetailTvShow.postValue(tvShow)
                }
            })
        }
        return  resultDetailTvShow
    }
}