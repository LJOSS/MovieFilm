package com.example.movie_project.utils

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter


abstract class BaseListAdapter<T, VH : BaseViewHolder<T>>(
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, VH>(diffCallback) {

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onBindViewHolder(holder: VH, position: Int, payloads: MutableList<Any>) {
        (payloads.firstOrNull() as? Set<*>)?.let { keys ->
            getItem(position)?.let {
                @Suppress("UNCHECKED_CAST")
                holder.update(it, keys as Set<String>)
            }
        } ?: onBindViewHolder(holder, position)
    }
}
