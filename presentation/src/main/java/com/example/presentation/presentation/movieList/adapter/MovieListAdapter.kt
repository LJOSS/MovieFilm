package com.example.presentation.presentation.movieList.adapter

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import com.example.presentation.R
import com.example.presentation.databinding.ItemMovieBinding
import com.example.presentation.presentation.entity.MovieUI
import com.example.presentation.utils.adapter.BaseListAdapter
import com.example.presentation.utils.adapter.BaseViewHolder
import com.example.presentation.utils.createGlideImage

class MovieListAdapter(
    private val onMovieClick: (MovieUI) -> Unit
) : BaseListAdapter<MovieUI, MovieListAdapter.ViewHolder>(
    diffCallback = DIFF_UTIL
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
        private val binding: ItemMovieBinding
    ) : BaseViewHolder<MovieUI>(binding.root) {

        override fun onBind(item: MovieUI) = with(binding) {
            textMovieTitle.text = "${item.title}"
            textYear.text = "${item.date}"
            textGenre.text = item.genres
            val spannable =
                SpannableString(itemView.context.getString(R.string.rating, "${item.rating.value}"))
            spannable.setSpan(
                ForegroundColorSpan(
                    ContextCompat.getColor(itemView.context, item.rating.ratingColor)
                ),
                0,
                item.rating.value.toString().length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            textRating.text = spannable
            textVotes.text = itemView.context.getString(R.string.votes, "${item.voteCount}")

            imgMoviePoster.createGlideImage(itemView.context, item.posterUrl)

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
                newItem: MovieUI
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: MovieUI,
                newItem: MovieUI
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
