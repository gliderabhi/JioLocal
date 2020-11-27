package com.example.jiolocal.dao

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class Services (val imageUrl: String, val title : String)

@BindingAdapter("android:image")
fun insertImage(view: View, url : String){
    Glide.with(view).load(url).into(view as ImageView)
}