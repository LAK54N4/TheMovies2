package com.laksana.themovies.data.source.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.laksana.themovies.LiveDataTestUtil
import com.laksana.themovies.callback.LoadMovieDetailsCallback
import com.laksana.themovies.callback.LoadNowPlayingMoviesCallback
import com.laksana.themovies.callback.LoadTvShowCallback
import com.laksana.themovies.callback.LoadTvShowDetailCallback
import com.laksana.themovies.utils.DataDummy
import com.laksana.themovies.utils.DetailDummy
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.eq
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    private val remote = mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val listMovieResponse = DataDummy.listMoviesResponse()
    private val listTvShowResponse = DataDummy.listTvShowResponse()
    private val detailMovieResponse = DetailDummy.listDetailMoviesResponse()[0]
    private val movieId = listMovieResponse[0].id
    private val detailTvShowResponse = DetailDummy.listsDetailTvShowResponse()[0]


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun getNowPlayingMovies() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[0] as LoadNowPlayingMoviesCallback)
                    .onAllMoviesReceived(listMovieResponse)
                null
            }. `when` (remote).getNowPlayingMovies(any())
        }

        val data = LiveDataTestUtil.getValue(movieRepository.getNowPlayingMovies())

        runBlocking {
            verify(remote).getNowPlayingMovies(any())
        }

        assertNotNull(data)
        assertEquals(listMovieResponse.size.toLong(), data.size.toLong())
    }

    @Test
    fun getTvShow() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as LoadTvShowCallback).onTvShowsReceived(listTvShowResponse)
                null
            }.`when`(remote).getTvShow(any())
        }
        val dataTvShow = LiveDataTestUtil.getValue(movieRepository.getTvShow())

        runBlocking {
            verify(remote).getTvShow(any())
        }

        assertNotNull(dataTvShow)
        assertEquals(listTvShowResponse.size.toLong(), dataTvShow.size.toLong())
    }

    @Test
    fun getMovieDetail() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[1] as LoadMovieDetailsCallback).onMovieDetailReceived(detailMovieResponse)
                null
            }.`when`(remote).getMoviesDetail(eq(movieId), any())
        }

        assertNotNull(detailMovieResponse)
        assertEquals(detailMovieResponse.id, 1)
    }

    @Test
    fun getTvShowDetail() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[1] as LoadTvShowDetailCallback).onTvShowDetailReceived(detailTvShowResponse)
                null
            }.`when`(remote).getTvShowDetail(eq(movieId), any())
        }
        assertNotNull(detailTvShowResponse)
        assertEquals(detailTvShowResponse.id, 1)
    }
}