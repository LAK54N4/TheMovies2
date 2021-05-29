package com.laksana.themovies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.laksana.themovies.data.source.remote.MovieRepository
import com.laksana.themovies.dependencyinjection.Injection
import com.laksana.themovies.ui.main.PageViewModel

class ViewModelFactory private constructor(private val movieRepository:MovieRepository)
    : ViewModelProvider.NewInstanceFactory() {

        companion object {
            @Volatile
            private var instance: ViewModelFactory? = null

            fun getInstance(): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideMovieRepository())
                }
        }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return when {
           modelClass.isAssignableFrom(PageViewModel::class.java) -> {
               PageViewModel(movieRepository) as T
           }
           modelClass.isAssignableFrom(DetailsViewModel::class.java) -> {
               DetailsViewModel(movieRepository) as T
           }
           else -> throw    Throwable("Unknown ViewModel class: "+ modelClass.name)
       }
    }
}