package com.example.movie_project.presentation.movie_detail

import android.os.Bundle
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.movie_project.R
import com.example.movie_project.databinding.FragmentMovieDetailBinding
import com.example.movie_project.utils.BaseFragment
import com.example.movie_project.utils.viewBinding

class MovieDetailFragment : BaseFragment(R.layout.fragment_movie_detail) {

    private val viewModel: MovieDetailViewModel by viewModel()
    private val binding by viewBinding(FragmentMovieDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}