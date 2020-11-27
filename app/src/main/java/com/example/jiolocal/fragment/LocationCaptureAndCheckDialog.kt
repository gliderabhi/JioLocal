package com.example.jiolocal.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jiolocal.R

class LocationCaptureAndCheckDialog : Fragment() {

    companion object {
        fun newInstance() = LocationCaptureAndCheckDialog()
    }

    private lateinit var viewModel: LocationCaptureAndCheckDialogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.location_capture_and_check_dialog_fragment,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            LocationCaptureAndCheckDialogViewModel::class.java
        )

        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            LocationCaptureAndCheckDialogViewModel::class.java
        )
        var moved = false
        val editBox = view.findViewById<EditText>(R.id.pinEnter)
        editBox.setOnClickListener {
        }
        val apply = view.findViewById<TextView>(R.id.applyButton)
        apply.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                ?.remove(this)?.commit()
        }
    }

}