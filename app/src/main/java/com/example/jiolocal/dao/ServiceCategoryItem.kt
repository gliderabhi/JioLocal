package com.example.jiolocal.dao

import android.graphics.Paint
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
fun setValue (view : View, st : String){
    (view as TextView).text = st
}

@BindingAdapter("setDoubleValues")
fun setVal(view: View , st : Int){
    val v = view as TextView
    if(v.id == R.id.orderPrice) {
        v.paintFlags = v.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }
    v.text = "Rs $st"
}

@BindingAdapter("setTime")
fun setTime(view: View , st : Int) {
    (view as TextView).text = "$st min"
}
