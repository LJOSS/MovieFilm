package com.example.movie_project.presentation.movie_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.movie_project.databinding.ItemMovieBinding
import com.example.movie_project.domain.entity.Movie
import com.example.movie_project.utils.BaseListAdapter
import com.example.movie_project.utils.BaseViewHolder

class MovieListAdapter(
    private val onMovieClick: (Movie) -> Unit,
) : BaseListAdapter<Movie, MovieListAdapter.ViewHolder>(
    diffCallback = DIFF_UTIL,
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class ViewHolder(
        private val binding: ItemMovieBinding,
    ) : BaseViewHolder<Movie>(binding.root) {

        override fun onBind(item: Movie) = with(binding) {
            textMovieTitle.text = "${item.title}"
            textYear.text = "${item.title}"

            Glide.with(itemView)
                .load(item.posterUrl)
                .into(imgMoviePoster)

            return@with
        }
    }

    companion object {

        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(
                oldItem: Movie,
                newItem: Movie,
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Movie,
                newItem: Movie,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}