package com.example.jiolocal.dao

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.jiolocal.R

class ServiceCategoryItem(val urls : List<String>,
                          val contentType : Int ,
                          val title : String,
                          val discountedPrice : Int,
                          val offerPrice : Int,
                          val time : Int)

@BindingAdapter("setText")
fun setValue (view : View, st : Any){
    (view as TextView).text = st as String
}
