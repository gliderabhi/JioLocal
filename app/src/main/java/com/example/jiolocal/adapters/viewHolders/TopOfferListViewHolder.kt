package com.example.jiolocal.adapters.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.dao.TopOffers
import com.example.jiolocal.databinding.ServiceListBinding

class TopOfferListViewHolder(offersBinding: ServiceListBinding) : RecyclerView.ViewHolder(offersBinding.root) {
    val offerBind = offersBinding
    fun bind(topOffers: TopOffers){
        offerBind.topOfferItem = topOffers
    }
}
