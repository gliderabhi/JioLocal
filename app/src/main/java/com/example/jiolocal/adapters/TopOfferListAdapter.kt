package com.example.jiolocal.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.R
import com.example.jiolocal.adapters.viewHolders.PopularServicesViewHolder
import com.example.jiolocal.adapters.viewHolders.ServiceCateogryItemViewHolder
import com.example.jiolocal.adapters.viewHolders.TopOfferListViewHolder
import com.example.jiolocal.dao.ServiceCategoryItem
import com.example.jiolocal.dao.ServiceDetails
import com.example.jiolocal.dao.TopOffers
import com.example.jiolocal.databinding.JioLocalServiceAddCostDetailsItemBinding
import com.example.jiolocal.databinding.ServiceItemBinding
import com.example.jiolocal.databinding.ServiceListBinding

class TopOfferListAdapter(val listEachType: List<Any> , val type : String) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TAG = "TopOfferListAdapter"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var offerBinding : ServiceListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.service_list, parent, false
        )

        when(type){
            "Top Offers" -> {
                val offersBinding : ServiceListBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context), R.layout.service_list, parent, false
                )

                return TopOfferListViewHolder(offersBinding)
            }

            "Popular Services" -> {
                val offersBinding : ServiceItemBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context), R.layout.service_item, parent, false
                )

                return PopularServicesViewHolder(offersBinding)
            }

            "Services Types" -> {
                val offerBinding : JioLocalServiceAddCostDetailsItemBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context), R.layout.jio_local_service_add_cost_details_item, parent,false
                )

                return ServiceCateogryItemViewHolder(offerBinding)
            }
        }

        return TopOfferListViewHolder(offerBinding)
    }

    override fun getItemCount(): Int {
        return listEachType.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(type){
            "Top Offers" -> {
                (holder as TopOfferListViewHolder).bind(listEachType[position] as TopOffers)
            }
            "Popular Services" -> {

                (holder as PopularServicesViewHolder).bind(listEachType[position] as ServiceDetails)
            }
            "Services Types" -> {
                Log.w(TAG, "onBindViewHolder: ${listEachType[position]}" )
                (holder as ServiceCateogryItemViewHolder).bind(/*listEachType[position] as ServiceCategoryItem*/)
            }
        }
    }

}
