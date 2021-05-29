package com.laksana.themovies.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.laksana.themovies.DetailsActivity
import com.laksana.themovies.DetailsActivity.Companion.EXTRA_DATA
import com.laksana.themovies.DetailsActivity.Companion.EXTRA_TYPE
import com.laksana.themovies.DetailsActivity.Companion.TYPE_TVSHOW
import com.laksana.themovies.adapter.TvShowsAdapter
import com.laksana.themovies.callback.ClickCallbackTvShow
import com.laksana.themovies.databinding.FragmentMainBinding
import com.laksana.themovies.model.TvShowModel
import com.laksana.themovies.viewmodel.ViewModelFactory

class TvShowFragment: Fragment(), ClickCallbackTvShow {

    private lateinit var pageViewModel: PageViewModel
    private var viewBinding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMainBinding.inflate(inflater, container, false)
        return viewBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentMainBinding.bind(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewBinding!!.progressBar.visibility = View.VISIBLE
        setRecyclerView()

        val factory = ViewModelFactory.getInstance()
        activity?.let {
            pageViewModel = ViewModelProvider(
                it, factory)[PageViewModel::class.java]
        }

        pageViewModel.getListTvShows().observe(viewLifecycleOwner, { listTvShow ->
            viewBinding!!.recyclerViewMovies.adapter.let { adapter ->
                when(adapter) {
                    is TvShowsAdapter -> adapter.setData(listTvShow)
                }
            }
        })
    }

    private fun setRecyclerView() {
        viewBinding!!.recyclerViewMovies.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TvShowsAdapter(this@TvShowFragment)
        }
    }

    override fun onItemClicked(view: View, data: TvShowModel) {
        val moveViewDetail = Intent(context, DetailsActivity::class.java)
        moveViewDetail.putExtra(EXTRA_DATA, data.id)
        moveViewDetail.putExtra(EXTRA_TYPE, TYPE_TVSHOW)
        startActivity(moveViewDetail)
        viewBinding!!.progressBar.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): TvShowFragment {
            return TvShowFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

}

