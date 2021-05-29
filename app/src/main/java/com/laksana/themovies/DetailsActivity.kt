package com.laksana.themovies

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.snackbar.Snackbar
import com.laksana.themovies.databinding.ActivityDetailTvShowBinding
import com.laksana.themovies.databinding.ActivityDetailsBinding
import com.laksana.themovies.model.MovieDetailModel
import com.laksana.themovies.model.TvShowDetailModel
import com.laksana.themovies.utils.Constants.IMAGE_ENDPOINT
import com.laksana.themovies.utils.Constants.POSTER_SIZE_W185
import com.laksana.themovies.utils.Constants.POSTER_SIZE_W780
import com.laksana.themovies.utils.Constants.setImage
import com.laksana.themovies.viewmodel.DetailsViewModel
import com.laksana.themovies.viewmodel.ViewModelFactory
import java.util.*


class DetailsActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
        const val TYPE_MOVIES = "type_movies"
        const val TYPE_TVSHOW = "type_tvShow"
    }

    private lateinit var detailsBinding: ActivityDetailsBinding
    private lateinit var detailsTvBinding: ActivityDetailTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsBinding = ActivityDetailsBinding.inflate(layoutInflater)
        detailsTvBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)

        val factory = ViewModelFactory.getInstance()
        val detailViewModel = ViewModelProvider(
            this@DetailsActivity, factory
        )[DetailsViewModel::class.java]

        val data = intent.getIntExtra(EXTRA_DATA, 0)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIES, ignoreCase = true)) {
            setContentView(detailsBinding.root)
            detailsBinding.progressBar.visibility = View.GONE

            val toolbarLayout = detailsBinding.detailToolbar
            setSupportActionBar(toolbarLayout)
            Objects.requireNonNull(supportActionBar!!).setDisplayHomeAsUpEnabled(true)
            detailsBinding.collapsingToolbar.setExpandedTitleColor(Color.TRANSPARENT)

            data.let {
                detailViewModel.getDetailMovie(data).observe(this@DetailsActivity, {
                    showToolbarTitle(it)
                    showData(it)
                })
            }

            detailsBinding.fab.setOnClickListener {
                Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }

        else if (type.equals(TYPE_TVSHOW, ignoreCase = true)) {
            setContentView(detailsTvBinding.root)
            detailsTvBinding.progressBar.visibility = View.GONE

            val toolbarLayout = detailsTvBinding.detailToolbar
            setSupportActionBar(toolbarLayout)
            Objects.requireNonNull(supportActionBar!!).setDisplayHomeAsUpEnabled(true)
            detailsTvBinding.collapsingToolbar.setExpandedTitleColor(Color.TRANSPARENT)

            data.let {
                detailViewModel.getDetailTvShow(data).observe(this@DetailsActivity, {
                    showToolbarTitleTvShow(it)
                    showTv(it)
                })
            }

            detailsTvBinding.fab.setOnClickListener {
                Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }
    }

    private fun showToolbarTitleTvShow(it: TvShowDetailModel) {
            val collapsingToolbar : CollapsingToolbarLayout = detailsTvBinding.collapsingToolbar
            collapsingToolbar.title = it.title
    }

    private fun showTv(it: TvShowDetailModel) {
        detailsTvBinding.tvTitle.text = it.title
        detailsTvBinding.tvLanguageValue.text = it.original_language
        detailsTvBinding.tvReleaseDateValue.text = it.first_air_date
        detailsTvBinding.tvOverviewValue.text = it.overview
        detailsTvBinding.tvEpisodesValue.text = it.number_episodes.toString()
        detailsTvBinding.tvSessionValue.text = it.number_seasons.toString()
        setImage(this, IMAGE_ENDPOINT+ POSTER_SIZE_W185 + it.poster_path,
            detailsTvBinding.imgDetailPoster)
        setImage(this, IMAGE_ENDPOINT+ POSTER_SIZE_W780 + it.backdrop_path,
            detailsTvBinding.imgBackground)
    }

    private fun showData(it: MovieDetailModel) {
        detailsBinding.tvTitle.text = it.title
        detailsBinding.tvReleaseDateValue.text = it.release_date
        detailsBinding.tvLanguageValue.text = it.language
        detailsBinding.tvOverviewValue.text = it.overview
        detailsBinding.tvBudgetValue.text = it.budget.toString()
        detailsBinding.tvRuntimeValue.text = it.runtime.toString()
        setImage(this, IMAGE_ENDPOINT+ POSTER_SIZE_W185 + it.poster_path,
            detailsBinding.imgDetailPoster)
        setImage(this, IMAGE_ENDPOINT+ POSTER_SIZE_W780 + it.backdrop_path,
            detailsBinding.imgBackground)
    }

    private fun showToolbarTitle(it: MovieDetailModel) {
        val collapsingToolbar : CollapsingToolbarLayout = detailsBinding.collapsingToolbar
        collapsingToolbar.title = it.title
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val i = Intent(this@DetailsActivity, MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        finish()
    }
}

