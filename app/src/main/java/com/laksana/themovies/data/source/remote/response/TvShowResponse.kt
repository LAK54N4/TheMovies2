package com.laksana.themovies.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class TvShowResponse<T>(

	@field:SerializedName("results")
	val results: List<TVShowResultsItem>,
)

data class TVShowResultsItem(

	@field:SerializedName("first_air_date")
	val firstAirDate: String,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("original_language")
	val originalLanguage: String,

	@field:SerializedName("poster_path")
	val posterPath: String,

	@field:SerializedName("backdrop_path")
	val backdropPath: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

)
