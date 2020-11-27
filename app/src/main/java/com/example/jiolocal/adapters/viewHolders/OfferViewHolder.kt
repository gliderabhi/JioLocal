package com.example.jiolocal.adapters.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.dao.Offers
import com.example.jiolocal.databinding.OffersFirstListItemBinding

class OfferViewHolder ( itemView: OffersFirstListItemBinding) : RecyclerView.ViewHolder(itemView.root) {
    var offerBinding  = itemView

    fun bind(offer : Offers){
        offerBinding.offersImage  = offer
    }
}