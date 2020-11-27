package com.example.jiolocal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.R
import com.example.jiolocal.adapters.viewHolders.OfferViewHolder
import com.example.jiolocal.dao.Offers
import com.example.jiolocal.databinding.OffersItemBinding

class OffersAdapters( var data: List<Offers>) : RecyclerView.Adapter<OfferViewHolder>() {

    private val TAG = "OffersAdapters"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        var view: View
        val offersBinding : OffersItemBinding  = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.offers_first_list_item, parent, false
        )

        return OfferViewHolder(offersBinding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.bind(data[position])
    }

}
