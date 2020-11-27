package com.example.jiolocal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.R
import com.example.jiolocal.adapters.viewHolders.TopOfferHeadListViewHolder
import com.example.jiolocal.adapters.viewHolders.TopOfferListViewHolder
import com.example.jiolocal.databinding.OfferHeadItemBinding
import com.example.jiolocal.databinding.ServiceListBinding

class TopOfferHeadAdapter(val headCategoryList: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecyclerView.ViewHolder {
        var view: View
        val offersBinding : OfferHeadItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.offer_head_item, parent, false
        )

        return TopOfferHeadListViewHolder(offersBinding)
    }

    override fun getItemCount(): Int {
        return headCategoryList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TopOfferHeadListViewHolder).bind(headCategoryList[position], position)
    }

}
