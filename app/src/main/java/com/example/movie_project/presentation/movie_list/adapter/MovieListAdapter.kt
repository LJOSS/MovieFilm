package com.example.movie_project.presentation.movie_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.movie_project.R
import com.example.movie_project.databinding.ItemMovieBinding
import com.example.movie_project.presentation.MovieUI
import com.example.movie_project.utils.BaseListAdapter
import com.example.movie_project.utils.BaseViewHolder

class MovieListAdapter(
    private val onMovieClick: (MovieUI) -> Unit,
) : BaseListAdapter<MovieUI, MovieListAdapter.ViewHolder>(
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
    ) : BaseViewHolder<MovieUI>(binding.root) {

        override fun onBind(item: MovieUI) = with(binding) {
            textMovieTitle.text = "${item.title}"
            textYear.text = "${item.year}"
            textGenre.text = item.genres
            textRating.setTextColor(
                ContextCompat.getColor(itemView.context, item.rating.ratingColor)
            )
            textRating.text = itemView.context.getString(R.string.rating, "${item.rating.value}")
            textVotes.text = itemView.context.getString(R.string.votes, "${item.voteCount}")

            Glide.with(itemView)
                .load(item.posterUrl)
                .into(imgMoviePoster)

            itemView.setOnClickListener {
                onMovieClick.invoke(item)
            }
            return@with
        }
    }

    companion object {

        private val DIFF_UTIL = object : DiffUtil.ItemCallback<MovieUI>() {
            override fun areItemsTheSame(
                oldItem: MovieUI,
                newItem: MovieUI,
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: MovieUI,
                newItem: MovieUI,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}