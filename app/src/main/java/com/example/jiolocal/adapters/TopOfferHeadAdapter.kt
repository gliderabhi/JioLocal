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

class TopOfferHeadAdapter(val headCategoryList: List<String>) : RecyclerView.Adapter<TopOfferHeadListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):TopOfferHeadListViewHolder {
        var view: View
        val offersBinding : OfferHeadItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.offer_head_item, parent, false
        )

        return TopOfferHeadListViewHolder(offersBinding)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TopOfferHeadListViewHolder, position: Int) {
        holder.bind(headCategoryList[position])
    }

}
