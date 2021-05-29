package com.laksana.themovies.callback

import android.view.View
import com.laksana.themovies.model.TvShowModel

interface ClickCallbackTvShow {
    fun onItemClicked(view: View, data: TvShowModel)
}