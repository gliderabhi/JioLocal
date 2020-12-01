package com.example.jiolocal.adapters.viewHolders

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.dao.Offers
import com.example.jiolocal.databinding.SingleImageItemBinding

class OfferViewHolder ( itemView: SingleImageItemBinding) : RecyclerView.ViewHolder(itemView.root) {
    var offerBinding  = itemView
    private  val TAG = "OfferViewHolder"
    fun bind(offer : Offers){
        offerBinding.offersImage  = offer
        offerBinding.offers.setOnClickListener {
            Log.e(TAG, "bind: offers has ben clicked with ${offer.ImageUrl}")
        }
    }
}