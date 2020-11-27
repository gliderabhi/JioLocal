package com.example.jiolocal.adapters.viewHolders

import android.text.Html
import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.R
import com.example.jiolocal.databinding.OfferHeadItemBinding

class TopOfferHeadListViewHolder(offersBinding: OfferHeadItemBinding) : RecyclerView.ViewHolder(offersBinding.root) {
    val loc = offersBinding
    fun bind(s: String, position: Int) {
        loc.serviceHeadTxt.text = s
        if(position == 0){
            loc.serviceHeadTxt.setTextColor(loc.root.context.resources.getColor(R.color.colorAccent))
            loc.serviceHeadTxt.text =(Html.fromHtml("<u>$s</u>"));
        }
    }

}
