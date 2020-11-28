package com.example.jiolocal.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jiolocal.R
import com.example.jiolocal.adapters.LocalDashBoardAdapter
import com.example.jiolocal.databinding.LocalDashBoardFragmentBinding
import com.example.jiolocal.fragment.viewModels.LocalDashBoardViewModel


class LocalDashBoardFragment : Fragment() {

    companion object {
        fun newInstance() =
            LocalDashBoardFragment()
    }

    private lateinit var viewModel: LocalDashBoardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: LocalDashBoardFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.local_dash_board_fragment, container, false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            LocalDashBoardViewModel::class.java
        )

        val recyclerView: RecyclerView = view.findViewById(R.id.popularServices)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val data = viewModel.getAllData()
        for (ds in data) {
           // Toast.makeText(context, "$ds", Toast.LENGTH_SHORT).show()
        }
        val adapter = LocalDashBoardAdapter(data)
        //adapter.setClickListener(this)
        recyclerView.adapter = adapter
    }

}