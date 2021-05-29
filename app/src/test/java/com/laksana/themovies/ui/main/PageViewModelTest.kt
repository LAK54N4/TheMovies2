package com.laksana.themovies.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.laksana.themovies.data.source.remote.MovieRepository
import com.laksana.themovies.data.source.remote.response.MovieResponse
import com.laksana.themovies.data.source.remote.response.ResultsItem
import com.laksana.themovies.model.DataModel
import com.laksana.themovies.model.TvShowModel
import com.laksana.themovies.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PageViewModelTest {

    private lateinit var viewModel: PageViewModel
    private val movieDummy = DataDummy.listMovies()
    private val tvShowDummy = DataDummy.listTvShows()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observerMovie: Observer<List<DataModel>>

    @Mock
    private lateinit var observerTvShow: Observer<List<TvShowModel>>

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = PageViewModel(movieRepository)
    }

    @Test
    fun getListPlayingMovies() {
        val movie = MutableLiveData<List<DataModel>>()
        movie.value = movieDummy

        `when`(movieRepository.getNowPlayingMovies()).thenReturn(movie)

        val listMovie = viewModel.getListPlayingMovies().value
        verify(movieRepository).getNowPlayingMovies()
        assertNotNull(listMovie)
        assertEquals(9, listMovie?.size)

        viewModel.getListPlayingMovies().observeForever(observerMovie)
        verify(observerMovie).onChanged(movieDummy)
    }

    @Test
    fun getListTvShows() {
        val tvShow = MutableLiveData<List<TvShowModel>>()
        tvShow.value = tvShowDummy

        `when`(movieRepository.getTvShow()).thenReturn(tvShow)

        val listShow = viewModel.getListTvShows().value
        verify(movieRepository).getTvShow()
        assertNotNull(tvShow)
        assertEquals(10, listShow?.size)

        viewModel.getListTvShows().observeForever(observerTvShow)
        verify(observerTvShow).onChanged(tvShowDummy)
    }
}