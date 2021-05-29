package com.laksana.themovies.callback

import android.view.View
import com.laksana.themovies.model.DataModel

interface ClickCallback {
    fun onItemClicked(view: View, data: DataModel)
}