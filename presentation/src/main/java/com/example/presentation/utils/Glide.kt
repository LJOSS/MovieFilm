package com.example.presentation.utils

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.presentation.R

fun ImageView.createGlideImage(
    context: Context,
    url: String,
    @DrawableRes errorView: Int = R.drawable.ic_feels_bad_man
) {
    Glide.with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .placeholder(AppCompatResources.getDrawable(context, errorView))
        .error(AppCompatResources.getDrawable(context, errorView))
        .into(this)
}
