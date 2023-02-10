package com.example.movie_project.presentation.movie_list

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.movie_project.R
import com.example.movie_project.databinding.FragmentMovieListBinding
import com.example.movie_project.utils.BaseFragment
import com.example.movie_project.utils.observe
import com.example.movie_project.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : BaseFragment(R.layout.fragment_movie_list) {

    private val viewModel: MovieListViewModel by viewModel()

    private val binding by viewBinding(FragmentMovieListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.data.observe(viewLifecycleOwner) {
            Log.d("MovieListFragment", "$it")
        }
    }
}