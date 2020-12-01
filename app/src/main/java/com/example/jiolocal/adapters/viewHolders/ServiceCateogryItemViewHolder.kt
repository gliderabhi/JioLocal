package com.example.jiolocal.adapters.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.dao.ServiceCategoryItem
import com.example.jiolocal.databinding.JioLocalServiceAddCostDetailsItemBinding

class ServiceCateogryItemViewHolder(offerBinding: JioLocalServiceAddCostDetailsItemBinding) : RecyclerView.ViewHolder(offerBinding.root) {
    val bindings  = offerBinding
    fun bind(serviceCategoryItem: ServiceCategoryItem) {
        //bindings.serviceImagesMerchant.adapter = TODO()

    }
}
