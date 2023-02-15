package com.example.presentation.presentation.movie_list

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentation.R
import com.example.presentation.databinding.FragmentMovieListBinding
import com.example.presentation.presentation.movie_list.adapter.MovieListAdapter
import com.example.presentation.utils.BaseFragment
import com.example.presentation.utils.PaginationScrollListener
import com.example.presentation.utils.observe
import com.example.presentation.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : BaseFragment<MovieListViewModel>(R.layout.fragment_movie_list) {

    override val viewModel: MovieListViewModel by viewModel()

    private val binding by viewBinding(FragmentMovieListBinding::bind)

    private val adapter: MovieListAdapter by lazy {
        MovieListAdapter(viewModel::onItemClicked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireContext())

        val pagination =
            object : PaginationScrollListener(layoutManager) {
                override fun onLoadMore() {
                    viewModel.onLoadMore()
                }
            }

        initView(pagination, layoutManager)
        initViewModel(pagination)
    }

    private fun initViewModel(pagination: PaginationScrollListener) {
        viewModel.data.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { value ->
            binding.srLoading.isRefreshing = value
            pagination.setLoading(value)
        }

        viewModel.onSelectMovie.observe(viewLifecycleOwner) { movieId ->
            findNavController().navigate(MovieListFragmentDirections.toMovieDetails(movieId))
        }
    }

    private fun initView(pagination: PaginationScrollListener, layoutManager: LinearLayoutManager) {
        with(binding) {
            srLoading.setOnRefreshListener {
                viewModel.onLoad(true)
            }

            rvList.layoutManager = layoutManager
            rvList.adapter = adapter
            rvList.addOnScrollListener(pagination)
        }
    }
}
