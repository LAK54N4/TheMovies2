package com.laksana.themovies.utils

import com.laksana.themovies.data.source.remote.response.MovieDetailsResponse
import com.laksana.themovies.data.source.remote.response.TvShowDetailsResponse
import com.laksana.themovies.model.MovieDetailModel
import com.laksana.themovies.model.TvShowDetailModel

object DetailDummy {
    fun listDetailMoviesResponse(): List<MovieDetailsResponse> {
        val detailMovieResponse = ArrayList<MovieDetailsResponse>()

        detailMovieResponse.add(
            MovieDetailsResponse(
                originalLanguage = "en",
                title = "",
                backdropPath = "",
                id = 1,
                budget = 0,
                overview = "",
                runtime = 60,
                posterPath = "",
                releaseDate = ""
            )
        )

        return detailMovieResponse
    }

    fun listsDetailTvShowResponse(): List<TvShowDetailsResponse>{
        val detailTvShowResponse = ArrayList<TvShowDetailsResponse>()

        detailTvShowResponse.add(
            TvShowDetailsResponse(
                numberOfEpisodes = 2,
                backdropPath = "",
                id = 1,
                numberOfSeasons = 1,
                firstAirDate = "",
                overview = "",
                originalLanguages = "",
                posterPath = "",
                name = "",

            )
        )
        return detailTvShowResponse
    }

    fun listDetailMovies() : List<MovieDetailModel> {
        val listDetailMovie = ArrayList<MovieDetailModel>()

        listDetailMovie.add(
            MovieDetailModel(
                id = 602211,
                backdrop_path = "https://image.tmdb.org/t/p/original/8lUbAZsJ8hJyanTFFRxzawlCwns.jpg",
                budget = 0,
                language = "en",
                title = "Fatman",
                overview = "A rowdy, unorthodox Santa Claus is fighting to save his declining business. Meanwhile, Billy, a neglected and precocious 12 year old, hires a hit man to kill Santa after receiving a lump of coal in his stocking.",
                poster_path = "https://image.tmdb.org/t/p/original/4n8QNNdk4BOX9Dslfbz5Dy6j1HK.jpg",
                release_date = "Nov 13, 2020",
                runtime = 0
            )
        )

        listDetailMovie.add(
            MovieDetailModel(
                id = 1,
                backdrop_path = "https://image.tmdb.org/t/p/original/86L8wqGMDbwURPni2t7FQ0nDjsH.jpg",
                budget = 0,
                language = "en",
                title = "Hard Kill",
                overview = "The work of billionaire tech CEO Donovan Chalmers is so valuable that he hires mercenaries to protect it, and a terrorist group kidnaps his daughter just to get it.",
                poster_path = "https://image.tmdb.org/t/p/original/A885WHVvtvaJXgzRMBE6VQqZDIM.jpg",
                release_date = "23 October 2020",
                runtime = 0
            )
        )

        return listDetailMovie
    }

    fun listDetailTvShows() : List<TvShowDetailModel> {
        val listDetailTvShow = ArrayList<TvShowDetailModel>()

        listDetailTvShow.add (
            TvShowDetailModel(
                id = 11,
                backdrop_path = "https://image.tmdb.org/t/p/original/o7qi2v4uWQ8bZ1tW3KI0Ztn2epk.jpg",
                original_language = "en",
                title = "The Mandalorian",
                overview = "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                poster_path = "https://image.tmdb.org/t/p/original/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                first_air_date = "Nov 12, 2019",
                number_episodes = 1,
                number_seasons = 2
            )
        )

        listDetailTvShow.add (
            TvShowDetailModel(
                id = 12,
                backdrop_path = "https://image.tmdb.org/t/p/original/uLLN44G7CR2zbQ5c90iZt0uVjZZ.jpg",
                original_language = "en",
                title = "The Good Doctor",
                overview = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
                poster_path = "https://image.tmdb.org/t/p/original/bi4tb3GMYFVNUom65SJm7A66rgM.jpg",
                first_air_date = "Sep 25, 2017",
                number_episodes = 1,
                number_seasons = 2
            )
        )
        return listDetailTvShow
    }


}