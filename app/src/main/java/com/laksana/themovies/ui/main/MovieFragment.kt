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
import com.laksana.themovies.DetailsActivity.Companion.TYPE_MOVIES
import com.laksana.themovies.adapter.MoviesAdapter
import com.laksana.themovies.callback.ClickCallback
import com.laksana.themovies.databinding.FragmentMainBinding
import com.laksana.themovies.model.DataModel
import com.laksana.themovies.viewmodel.ViewModelFactory

/**
 * A placeholder fragment containing a simple view.
 */

class MovieFragment : Fragment(), ClickCallback {

    private lateinit var pageViewModel: PageViewModel
    private var viewBinding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMainBinding.inflate(inflater, container, false)
        return viewBinding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewBinding!!.progressBar.visibility = View.VISIBLE
        setRecyclerview()

        val factory = ViewModelFactory.getInstance()
        activity?.let {
            pageViewModel =ViewModelProvider(it, factory)[PageViewModel::class.java]
        }

        pageViewModel.getListPlayingMovies().observe(viewLifecycleOwner, { listMovie ->
            viewBinding!!.recyclerViewMovies.adapter.let { adapter ->
                when (adapter) {
                    is MoviesAdapter -> adapter.setData(listMovie)
                }
            }
        })
    }

    private fun setRecyclerview() {
        viewBinding!!.recyclerViewMovies.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MoviesAdapter(this@MovieFragment)
        }
    }

    override fun onItemClicked(view: View, data: DataModel) {
        val moveViewDetail = Intent(context, DetailsActivity::class.java)
        moveViewDetail.putExtra(DetailsActivity.EXTRA_DATA, data.id)
        moveViewDetail.putExtra(DetailsActivity.EXTRA_TYPE, TYPE_MOVIES)
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
        fun newInstance(sectionNumber: Int): MovieFragment {
            return MovieFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

}
