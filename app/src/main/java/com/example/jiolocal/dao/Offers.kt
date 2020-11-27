package com.example.jiolocal.dao

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class Offers (val ImageUrl : String)

    private val TAG = "Offers"
    @BindingAdapter("android:image")
    fun loadImage (view : View, url: String) {
        Log.e(TAG, "loadImage: $url" )
        Glide.with(view).load(url).into(view as ImageView)
    }
