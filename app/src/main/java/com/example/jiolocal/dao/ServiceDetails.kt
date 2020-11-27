package com.example.jiolocal.dao

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class ServiceDetails (val imageUrl : String,
                      val ServiceName : String,
                      val AddressLine1 : String,
                      val AddressLine2: String ,
                      val rate: Double,
                      val duration : Double,
                      val ratings : Double,
                      val noOfRatings : Long)

@BindingAdapter("setDuration")
fun setDuration (view: View, duration: Double){
    (view as TextView)
    if(duration==1.0){
        view.text = "/day"
    }
    if(duration==7.0){
        view.text = "/week"
    }
    if(duration>=28.0){
        view.text = "/month"
    }
}
@BindingAdapter("text")
fun Setrate(view : View, rate : String) {
    (view as TextView)
    view.text = "Rs. $rate"
}


@BindingAdapter("android:image")
fun addImage(view: View, url : String){
    Glide.with(view).load(url).into(view as ImageView)
}