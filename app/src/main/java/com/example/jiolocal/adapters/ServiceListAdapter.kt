package com.example.jiolocal.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.example.jiolocal.R
import com.example.jiolocal.dao.Services
import com.example.jiolocal.databinding.GridItemBinding

class ServiceListAdapter(val data: List<Services>, context: Context) : BaseAdapter() {
    val contexts = context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val grid: GridItemBinding
        val layoutInflater = LayoutInflater.from(parent?.context)
        grid = DataBindingUtil.inflate(layoutInflater, R.layout.grid_item, parent, false)
        grid.gridServiceItem = data[position]
        return grid.root
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return data.size
    }
}
