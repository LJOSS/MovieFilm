package com.example.presentation.presentation.movieDetail

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.presentation.R
import com.example.presentation.databinding.FragmentMovieDetailBinding
import com.example.presentation.utils.BaseFragment
import com.example.presentation.utils.createGlideImage
import com.example.presentation.utils.observe
import com.example.presentation.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MovieDetailFragment : BaseFragment<MovieDetailViewModel>(R.layout.fragment_movie_detail) {

    private val args: MovieDetailFragmentArgs by navArgs()

    override val viewModel: MovieDetailViewModel by viewModel(parameters = { parametersOf(args.movieid) })

    private val binding by viewBinding(FragmentMovieDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initToolbar()
    }

    private fun initToolbar() {
        setupWithNavController(binding.toolbar, findNavController())
        // TODO: Fix color
        binding.toolbar.navigationIcon?.mutate()?.let {
            it.setTint(
                ContextCompat.getColor(requireContext(), R.color.colorOnPrimary)
            )
            binding.toolbar.navigationIcon = it
        }
    }

    private fun initViewModel() {
        with(binding) {
            viewModel.data.observe(viewLifecycleOwner) {
                imageMoviePoster.createGlideImage(requireContext(), it.posterPath)
                textMovieTitle.text = it.title
                textMovieOverview.text = it.overview
                releaseDateValue.text = it.releaseDate
                budgetValue.text = it.budget
                statusValue.text = it.status
                genres.text = it.genres
            }
        }
    }
}
