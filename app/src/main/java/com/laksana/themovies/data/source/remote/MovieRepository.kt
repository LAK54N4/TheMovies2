package com.laksana.themovies.data.source.remote

import android.util.Log
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

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource):
    MovieDataSource {
    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteDataSource)
            }
    }

    override fun getNowPlayingMovies(): LiveData<List<DataModel>> {
        val movieResult = MutableLiveData<List<DataModel>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getNowPlayingMovies(object : LoadNowPlayingMoviesCallback {
                override fun onAllMoviesReceived(movieResponse: List<ResultsItem>) {
                    val listMovie = ArrayList<DataModel>()
                    for (response in movieResponse) {
                        val movie = DataModel(
                            response.id,
                            response.title,
                            response.overview,
                            response.posterPath,
                            response.releaseDate,
                            response.backdropPath,
                        )
                        listMovie.add(movie)
                    }
                    movieResult.postValue(listMovie)
                }
            })
        }
        return movieResult
    }

    override fun getTvShow(): LiveData<List<TvShowModel>> {
        val tvShowResult = MutableLiveData<List<TvShowModel>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTvShow(object : LoadTvShowCallback {
                override fun onTvShowsReceived(tvShowResponse: List<TVShowResultsItem>) {
                    Log.d("cek0", tvShowResponse.toString())

                    val listTvShow = ArrayList<TvShowModel>()
                    for(response in tvShowResponse){
                        val tvShow = TvShowModel(
                            response.id,
                            response.name,
                            response.overview,
                            response.posterPath,
                            response.firstAirDate,
                            response.backdropPath,
                        )
                        listTvShow.add(tvShow)
                        Log.d("cek1", tvShow.toString())
                    }
                    tvShowResult.postValue(listTvShow)
                }
            })
        }
        return tvShowResult
    }

    override fun getMovieDetail(movieId: Int): LiveData<MovieDetailModel> {
        val resultMovieDetail = MutableLiveData<MovieDetailModel>()
        CoroutineScope(IO).launch {
            remoteDataSource.getMoviesDetail(movieId, object : LoadMovieDetailsCallback {
                override fun onMovieDetailReceived(movieDetailResponse: MovieDetailsResponse){
                    val movieDetail = MovieDetailModel(
                        movieDetailResponse.id,
                        movieDetailResponse.backdropPath,
                        movieDetailResponse.budget,
                        movieDetailResponse.originalLanguage,
                        movieDetailResponse.title,
                        movieDetailResponse.overview,
                        movieDetailResponse.posterPath,
                        movieDetailResponse.releaseDate,
                        movieDetailResponse.runtime
                    )
                    resultMovieDetail.postValue(movieDetail)
                }
            } )
        }
        return resultMovieDetail
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<TvShowDetailModel> {
        val resultTvShowDetailModel = MutableLiveData<TvShowDetailModel>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTvShowDetail(tvShowId, object : LoadTvShowDetailCallback {
                override fun onTvShowDetailReceived(tvShowDetailResponse: TvShowDetailsResponse) {
                    val tvShowDetail = TvShowDetailModel(
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
                    resultTvShowDetailModel.postValue(tvShowDetail)
                }
            })
        }
        return resultTvShowDetailModel
    }


}

