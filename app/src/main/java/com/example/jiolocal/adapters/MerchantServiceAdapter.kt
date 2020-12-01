package com.example.jiolocal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.R
import com.example.jiolocal.adapters.viewHolders.OfferViewHolder
import com.example.jiolocal.dao.Offers
import com.example.jiolocal.databinding.SingleImageItemBinding

class MerchantServiceAdapter(val imagesList: ArrayList<String>, val dataType : Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val offersBinding : SingleImageItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.single_image_item, parent, false
        )

        when(dataType) {
            1 -> {
                return OfferViewHolder(offersBinding)
            }

            2 -> {
                //TODO(Video holder )

            }
        }

        return OfferViewHolder(offersBinding)

    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(dataType) {
            1 -> {
                (holder as OfferViewHolder).bind(Offers(imagesList[position]))
            }

            2 -> {
                //TODO(Video holder )

            }
        }
    }

}
