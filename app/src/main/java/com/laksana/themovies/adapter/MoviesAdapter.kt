package com.laksana.themovies.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laksana.themovies.databinding.ItemMovieBinding
import com.laksana.themovies.model.DataModel
import com.laksana.themovies.ui.main.MovieFragment
import com.laksana.themovies.utils.Constants.IMAGE_ENDPOINT
import com.laksana.themovies.utils.Constants.POSTER_SIZE_W185
import com.laksana.themovies.utils.Constants.setImage

class MoviesAdapter(private var callback: MovieFragment): RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private var moviesItem: ArrayList<DataModel> = ArrayList()

    fun setData(data: List<DataModel>?){
        if(data == null) return
        moviesItem.clear()
        moviesItem.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: DataModel) {
            with(itemView){
                setImage(context, IMAGE_ENDPOINT+ POSTER_SIZE_W185+ movie.poster, binding.poster)
            }

            binding.tvTitle.text = movie.title
            binding.tvRelease.text = movie.release
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.ViewHolder, position: Int) {
        holder.bind(moviesItem[position])
        holder.itemView.setOnClickListener {
            callback.onItemClicked(it, moviesItem[position])
        }
    }

    override fun getItemCount(): Int {
        return  moviesItem.size
    }

}