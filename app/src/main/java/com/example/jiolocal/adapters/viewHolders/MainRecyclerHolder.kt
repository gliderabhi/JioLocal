package com.example.jiolocal.adapters.viewHolders

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.R

class MainRecyclerHolder(root: View) : RecyclerView.ViewHolder(root) {

    var recyclerView1: RecyclerView = itemView.findViewById(R.id.recycler1) as RecyclerView
    var recyclerView2: RecyclerView = itemView.findViewById(R.id.recycler2) as RecyclerView
    var simpleView : ConstraintLayout = itemView.findViewById(R.id.serviceList)
    var dataType : TextView = itemView.findViewById(R.id.dataType)
    var darkStrip : View = itemView.findViewById(R.id.blackStrip)
}
