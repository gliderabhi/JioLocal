package com.example.jiolocal.adapters.viewHolders
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.MainActivity
import com.example.jiolocal.R
import com.example.jiolocal.dao.ServiceDetails
import com.example.jiolocal.databinding.ServiceItemBinding
import com.example.jiolocal.fragment.ServiceDetailsPage
import com.example.jiolocal.fragment.TopBarLocationUpdate
import kotlinx.android.synthetic.main.activity_main.view.*

class PopularServicesViewHolder(popularServiceBinding: ServiceItemBinding) : RecyclerView.ViewHolder(popularServiceBinding.root) {
    val bindings = popularServiceBinding
    private val TAG = "PopularServicesViewHold"
    fun bind(serviceDetails: ServiceDetails) {
        bindings.popularServiceItem = serviceDetails
        val activity: MainActivity = bindings.serviceItemCard.context as MainActivity
        bindings.serviceItemCard.setOnClickListener {
            activity.supportFragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(
                    activity.findViewById<FragmentContainerView>(R.id.fragmentContainer).id,
                    ServiceDetailsPage()
                ).commit()
            activity.findViewById<FragmentContainerView>(R.id.locationDisplay).visibility = View.GONE
            Log.e(TAG, "bind: hua ki ni ?")
        }
    }

}
