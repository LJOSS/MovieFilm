package com.example.movie_project.presentation.movie_detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.movie_project.R
import com.example.movie_project.databinding.FragmentMovieDetailBinding
import com.example.movie_project.utils.BaseFragment
import com.example.movie_project.utils.createGlideImage
import com.example.movie_project.utils.observe
import com.example.movie_project.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MovieDetailFragment : BaseFragment<MovieDetailViewModel>(R.layout.fragment_movie_detail) {

    private val args: MovieDetailFragmentArgs by navArgs()

    override val viewModel: MovieDetailViewModel by viewModel(
        parameters = { parametersOf(args.movieid) }
    )

    private val binding by viewBinding(FragmentMovieDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initToolbar()
    }

    private fun initToolbar() {
        setupWithNavController(binding.toolbar, findNavController())
        //TODO: Fix color
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
                Log.d("MovieInfo Data", "$it")

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