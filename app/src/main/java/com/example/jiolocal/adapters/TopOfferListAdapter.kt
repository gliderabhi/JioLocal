package com.example.jiolocal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.R
import com.example.jiolocal.adapters.viewHolders.TopOfferListViewHolder
import com.example.jiolocal.dao.TopOffers
import com.example.jiolocal.databinding.ServiceListBinding

class TopOfferListAdapter(val listEachType: List<TopOffers>) : RecyclerView.Adapter<TopOfferListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopOfferListViewHolder {
        var view: View
        val offersBinding : ServiceListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.service_list, parent, false
        )

        return TopOfferListViewHolder(offersBinding)
    }

    override fun getItemCount(): Int {
        return listEachType.size
    }

    override fun onBindViewHolder(holder: TopOfferListViewHolder, position: Int) {
        holder.bind(listEachType[position])
    }

}
