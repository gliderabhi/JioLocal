package com.example.jiolocal.adapters.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.databinding.OfferHeadItemBinding

class TopOfferHeadListViewHolder(offersBinding: OfferHeadItemBinding) : RecyclerView.ViewHolder(offersBinding.root) {
    val loc = offersBinding
    fun bind(s: String) {
        loc.serviceHeadTxt.text = s
    }

}
