package com.example.movie_project.utils

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.movie_project.R

fun ImageView.createGlideImage(
    context: Context,
    url: String,
    @DrawableRes errorView: Int = R.drawable.ic_feels_bad_man
) {
    Glide.with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .error(AppCompatResources.getDrawable(context, errorView))
        .into(this)
}