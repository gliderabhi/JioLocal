package com.example.jiolocal.adapters.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.dao.Offers
import com.example.jiolocal.databinding.OffersItemBinding

class OfferViewHolder ( itemView: OffersItemBinding) : RecyclerView.ViewHolder(itemView.root) {
    var offerBinding  = itemView

    fun bind(offer : Offers){
        offerBinding.offersImage  = offer
    }
}