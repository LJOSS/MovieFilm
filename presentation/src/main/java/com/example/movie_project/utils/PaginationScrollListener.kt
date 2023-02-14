package com.example.movie_project.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


abstract class PaginationScrollListener(
    private val manager: LinearLayoutManager
): RecyclerView.OnScrollListener() {

    private var _isLastPage: Boolean = false
    private var _isLoading: Boolean = false

    fun setLastPage(value: Boolean) {
        _isLastPage = value
    }

    fun setLoading(value: Boolean) {
        _isLoading = value
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = manager.childCount
        val totalItemCount = manager.itemCount
        val firstVisibleItemPosition = manager.findFirstVisibleItemPosition()

        if (!_isLoading && !_isLastPage) {
            if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
                setLoading(true)
                onLoadMore()
            }
        }
    }

    abstract fun onLoadMore()

}
