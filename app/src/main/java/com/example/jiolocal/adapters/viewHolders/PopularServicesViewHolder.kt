package com.example.jiolocal.adapters.viewHolders
import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.dao.ServiceDetails
import com.example.jiolocal.databinding.ServiceItemBinding

class PopularServicesViewHolder(popularServiceBinding: ServiceItemBinding) : RecyclerView.ViewHolder(popularServiceBinding.root) {
    val bindings = popularServiceBinding

    fun bind(serviceDetails: ServiceDetails) {
        bindings.popularServiceItem = serviceDetails
    }

}
