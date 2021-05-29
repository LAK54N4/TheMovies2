package com.laksana.themovies.model


data class TvShowModel(
    var id: Int = 0,
    var name: String = "",
    var overview: String = "",
    var poster: String = "",
    var release: String= "",
    var imgBackground: String? = null
)