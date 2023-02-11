package com.example.movie_project.presentation.movie_list

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie_project.R
import com.example.movie_project.databinding.FragmentMovieListBinding
import com.example.movie_project.presentation.movie_list.adapter.MovieListAdapter
import com.example.movie_project.utils.BaseFragment
import com.example.movie_project.utils.PaginationScrollListener
import com.example.movie_project.utils.observe
import com.example.movie_project.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : BaseFragment(R.layout.fragment_movie_list) {

    private val viewModel: MovieListViewModel by viewModel()

    private val binding by viewBinding(FragmentMovieListBinding::bind)

    private val adapter: MovieListAdapter by lazy {
        MovieListAdapter(onMovieClick = {
            viewModel.onItemClicked(it)
        })
    }

    private val layoutManager by lazy { LinearLayoutManager(requireContext()) }

    private val pagination by lazy {
        object : PaginationScrollListener(layoutManager) {
            override fun onLoadMore() {
                viewModel.onLoadMore()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.data.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { value ->
            binding.srLoading.isRefreshing = value
            pagination.setLoading(value)
        }

        viewModel.onSelectMovie.observe(viewLifecycleOwner) { value ->
            findNavController().navigate(R.id.toMovieDetails)
        }
    }

    private fun initView() {
        with(binding) {

            srLoading.setOnRefreshListener {
                viewModel.onLoad(true)
            }

            rvList.adapter = adapter
            rvList.addOnScrollListener(pagination)
            rvList.layoutManager = layoutManager
        }
    }
}
