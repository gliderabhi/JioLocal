package com.example.jiolocal.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.R
import com.example.jiolocal.adapters.viewHolders.MainRecyclerHolder
import com.example.jiolocal.dao.*
import com.example.jiolocal.databinding.DashboardItemBaseLayoutBinding
import kotlinx.android.synthetic.main.dashboard_item_base_layout.view.*

class LocalDashBoardAdapter(var data : List<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val TAG = "LocalDashBoardAdapter"
    val TypeOffers = 1
    val TypeServiceList = 2
    val TypeTopOffers = 3
    val TypePopularServices = 4
    val TypeRecentylViewed = 5
    lateinit var context : Context
    val viewPool : RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding : DashboardItemBaseLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context) , R.layout.dashboard_item_base_layout,parent,false
        )
        context = parent.context
        return MainRecyclerHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    var count =0
    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        Log.e(TAG, "onBindViewHolder: $position" )
        when (getItemViewType(position)) {
            TypeOffers -> {
                (viewHolder as MainRecyclerHolder)
                val parentItem = data[position] as List<Offers>

                //offer view nly a single horizontal recycler
                viewHolder.recyclerView1.layoutManager = LinearLayoutManager(
                    viewHolder.recyclerView1.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                viewHolder.recyclerView1.adapter = OffersAdapters(parentItem)
                viewHolder.simpleView.visibility = View.GONE
                viewHolder.recyclerView2.visibility = View.GONE
                viewHolder.recyclerView1.visibility = View.VISIBLE
                viewHolder.dataType.visibility = View.GONE
            }
            TypeServiceList -> {
                (viewHolder as MainRecyclerHolder)
                val parentItem = data[position] as List<Services>
                viewHolder.dataType.text = context.getString(R.string.ServiceListHead)
                viewHolder.simpleView.ServiceListGrid.adapter  = ServiceListAdapter(parentItem, context)
                viewHolder.simpleView.visibility = View.VISIBLE
                viewHolder.recyclerView2.visibility = View.GONE
                viewHolder.recyclerView1.visibility = View.GONE
                viewHolder.dataType.visibility  = View.VISIBLE
            }
            TypeTopOffers -> {
                (viewHolder as MainRecyclerHolder)
                val parentItem = data[position] as TopOfferList
                viewHolder.recyclerView1.layoutManager = LinearLayoutManager(
                    viewHolder.recyclerView1.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                viewHolder.recyclerView2.layoutManager = LinearLayoutManager(
                    viewHolder.recyclerView2.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )

                viewHolder.dataType.text = context.getString(R.string.TopOffers)
                viewHolder.recyclerView1.adapter = TopOfferHeadAdapter(parentItem.headCategoryList)
                viewHolder.recyclerView2.adapter = TopOfferListAdapter(
                    parentItem.listEachType[0] as List<TopOffers>,
                    context.getString(R.string.TopOffers)
                )
                viewHolder.dataType.text = context.getString(R.string.TopOffers)

                viewHolder.recyclerView1.setOnClickListener {

                }
                viewHolder.simpleView.visibility = View.GONE
                viewHolder.recyclerView2.visibility = View.VISIBLE
                viewHolder.recyclerView1.visibility = View.VISIBLE
                viewHolder.dataType.visibility = View.VISIBLE
            }

            TypePopularServices -> {

                (viewHolder as MainRecyclerHolder)
                val parentItem = data[position] as PopularServices

                viewHolder.dataType.text = context.getString(R.string.PopularServices)
                viewHolder.recyclerView1.layoutManager = LinearLayoutManager(
                    viewHolder.recyclerView1.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                viewHolder.recyclerView2.layoutManager = LinearLayoutManager(
                    viewHolder.recyclerView2.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )

                viewHolder.recyclerView1.adapter = TopOfferHeadAdapter(parentItem.headCategoryList)
                viewHolder.recyclerView2.adapter = TopOfferListAdapter(
                    parentItem.listEachType[0] as List<ServiceDetails>,
                    context.getString(R.string.PopularServices)
                )


                viewHolder.simpleView.visibility = View.GONE
                viewHolder.recyclerView2.visibility = View.VISIBLE
                viewHolder.recyclerView1.visibility = View.VISIBLE
                viewHolder.dataType.visibility = View.VISIBLE
                // AdapterImplementation(viewHolder,parentItem,viewPool, context.getString(R.string.Offers))

            }

            TypeRecentylViewed -> {

                (viewHolder as MainRecyclerHolder)
                val parentItem = data[position] as PopularServices

                viewHolder.dataType.text = context.getString(R.string.recentlyViewed)
                viewHolder.recyclerView1.layoutManager = LinearLayoutManager(
                    viewHolder.recyclerView1.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                viewHolder.recyclerView2.layoutManager = LinearLayoutManager(
                    viewHolder.recyclerView2.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )

                viewHolder.recyclerView1.adapter = TopOfferHeadAdapter(parentItem.headCategoryList)
                viewHolder.recyclerView2.adapter = TopOfferListAdapter(
                    parentItem.listEachType[0] as List<ServiceDetails>,
                    context.getString(R.string.PopularServices)
                )


                viewHolder.simpleView.visibility = View.GONE
                viewHolder.recyclerView2.visibility = View.VISIBLE
                viewHolder.recyclerView1.visibility = View.VISIBLE
                viewHolder.dataType.visibility = View.VISIBLE
                // AdapterImplementation(viewHolder,parentItem,viewPool, context.getString(R.string.Offers))

            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        when(position) {
            0 -> return TypeOffers
            1 -> return TypeServiceList
            2 -> return TypeTopOffers
            3 -> return TypePopularServices
            4 -> return TypeRecentylViewed
        }
        return TypeOffers
    }

/*
    fun AdapterImplementation(
        viewHolder: MainRecyclerHolder,
        parentIem: List<Any>,
        viewPool: RecyclerView.RecycledViewPool, dataType: String
    ) {
        val layoutManager = LinearLayoutManager(
            viewHolder.recyclerView1.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        layoutManager.initialPrefetchItemCount = parentIem.size
        viewHolder.recyclerView1.layoutManager = layoutManager

        val layoutManager2 = LinearLayoutManager(
            viewHolder.recyclerView2.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        viewHolder.recyclerView2.layoutManager = layoutManager2

        when(dataType) {
            context.getString(R.string.Offers)->
                viewHolder.recyclerView1.adapter = OffersAdapters(parentIem as List<Offers>)
            context.getString(R.string.TypeServiceList) ->
               //this is a simple view
             TODO()
            *//*
                viewHolder.recyclerView.adapter = ServiceListAdapter(parentIem as List<ServiceCategories>)*//*
            context.getString(R.string.TopOffers) ->
                viewHolder.recyclerView1.adapter = TopOffersCategoryTitleAdapter(parentIem as List<TwoImageModel>)
            *//*context.getString(R.string.PopularServices)->
                viewHolder.recyclerView.adapter = EmployeeAdapter(parentIem as List<Employee>)
            context.getString(R.string.TopRecentlyViewed)->
                viewHolder.recyclerView.adapter = EmployeeAdapter(parentIem as List<Employee>)
*//*
        }
        viewHolder.recyclerView1.setRecycledViewPool(viewPool)
    }*/
}