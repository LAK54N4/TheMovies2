package com.laksana.themovies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laksana.themovies.databinding.ItemMovieBinding
import com.laksana.themovies.model.TvShowModel
import com.laksana.themovies.ui.main.TvShowFragment
import com.laksana.themovies.utils.Constants

class TvShowsAdapter(private var callback: TvShowFragment) : RecyclerView.Adapter<TvShowsAdapter.ViewHolder>() {

    private var moviesItem: ArrayList<TvShowModel> = ArrayList()

    fun setData(data: List<TvShowModel>) {
        moviesItem.clear()
        moviesItem.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowModel) {
            with(itemView){
                Constants.setImage(
                    context,
                    Constants.IMAGE_ENDPOINT + Constants.POSTER_SIZE_W185 + tvShow.poster,
                    binding.poster
                )
            }
            binding.tvTitle.text = tvShow.name
            binding.tvRelease.text = tvShow.release
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsAdapter.ViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowsAdapter.ViewHolder, position: Int) {
        val movie = moviesItem[position]
        holder.bind(movie)

        holder.itemView.setOnClickListener {
            callback.onItemClicked(it, moviesItem[position])
        }
    }

    override fun getItemCount(): Int {
        return moviesItem.size
    }

}

