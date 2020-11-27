package com.example.jiolocal.dao

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class TopOffers (val imageUrl : String , val title : String , val price : Double )

@BindingAdapter("Image")
fun insertImageOffer(view: View, imageUrl: String) {
    Glide.with(view).load(imageUrl).into(view as ImageView)
}

@BindingAdapter("rate")
fun setRate(view: View, price: Double){
    (view as TextView).text = price.toString()
}

@BindingAdapter("title")
fun setTitle(view: View, title: String){
    (view as TextView).text = title
}
