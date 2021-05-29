package com.laksana.themovies.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.laksana.themovies.data.source.remote.MovieRepository
import com.laksana.themovies.model.MovieDetailModel
import com.laksana.themovies.model.TvShowDetailModel
import com.laksana.themovies.utils.DetailDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailsViewModelTest {

    private lateinit var viewModel: DetailsViewModel
    private val movieDummy = DetailDummy.listDetailMovies()[0]
    private val tvShowDummy = DetailDummy.listDetailTvShows()[0]
    private val movieId = movieDummy.id
    private val tvShowId = tvShowDummy.id

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observerMovie: Observer<MovieDetailModel>

    @Mock
    private lateinit var observerTvShow: Observer<TvShowDetailModel>

    @Before
    fun setUp() {
        viewModel = DetailsViewModel(movieRepository)
    }

    @Test
    fun getDetailMovie() {
        val dummyMovie = MutableLiveData<MovieDetailModel>()
        dummyMovie.value = movieDummy

        `when` (movieRepository.getMovieDetail(movieId)).thenReturn(dummyMovie)

        val movie = viewModel.getDetailMovie(movieId).value

        assertNotNull(movie)
        assertEquals(movieDummy.id, movie?.id)
        assertEquals(movieDummy.title, movie?.title)
        assertEquals(movieDummy.overview, movie?.overview)
        assertEquals(movieDummy.poster_path, movie?.poster_path)
        assertEquals(movieDummy.backdrop_path, movie?.backdrop_path)
        assertEquals(movieDummy.language, movie?.language)
        assertEquals(movieDummy.budget, movie?.budget)
        assertEquals(movieDummy.runtime, movie?.runtime)
        assertEquals(movieDummy.release_date, movie?.release_date)

        viewModel.getDetailMovie(movieId).observeForever(observerMovie)
        verify(observerMovie).onChanged(movieDummy)
    }

    @Test
    fun getDetailTvShow() {
        val dummyTvShow = MutableLiveData<TvShowDetailModel>()
        dummyTvShow.value = tvShowDummy

        `when` (movieRepository.getTvShowDetail(tvShowId)).thenReturn(dummyTvShow)

        val tvShow = viewModel.getDetailTvShow(tvShowId).value

        assertNotNull(tvShow)
        assertEquals(tvShowDummy.id, tvShow?.id)
        assertEquals(tvShowDummy.title, tvShow?.title)
        assertEquals(tvShowDummy.overview, tvShow?.overview)
        assertEquals(tvShowDummy.poster_path, tvShow?.poster_path)
        assertEquals(tvShowDummy.backdrop_path, tvShow?.backdrop_path)
        assertEquals(tvShowDummy.first_air_date, tvShow?.first_air_date)
        assertEquals(tvShowDummy.original_language, tvShow?.original_language)
        assertEquals(tvShowDummy.number_episodes, tvShow?.number_episodes)
        assertEquals(tvShowDummy.number_seasons, tvShow?.number_seasons)
        assertEquals(tvShowDummy.id, tvShow?.id)

        viewModel.getDetailTvShow(tvShowId).observeForever(observerTvShow)
        verify(observerTvShow).onChanged(tvShowDummy)
    }
}