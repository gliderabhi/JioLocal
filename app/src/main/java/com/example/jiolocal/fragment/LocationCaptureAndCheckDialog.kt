package com.example.jiolocal.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.jiolocal.MainActivity
import com.example.jiolocal.R
import com.example.jiolocal.fragment.viewModels.LocationCaptureAndCheckDialogViewModel


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

        val blocker = (activity as MainActivity).findViewById<ImageView>(R.id.blocker)
        var moved = false
        val editBox = view.findViewById<EditText>(R.id.pinEnter)
        editBox.setOnClickListener {
        }
        val apply = view.findViewById<TextView>(R.id.applyButton)
        apply.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                ?.remove(this)?.commit()
            hideKeyboardFrom(context!!, view)
            blocker.visibility = View.GONE
        }

        blocker.setOnClickListener {
            blocker.visibility = View.GONE
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                ?.remove(this)?.commit()
        }

    }
    fun hideKeyboardFrom(context: Context, view: View) {
        val imm: InputMethodManager =
            context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}