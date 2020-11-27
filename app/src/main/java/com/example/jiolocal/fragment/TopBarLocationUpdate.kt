package com.example.jiolocal.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentTransaction
import com.example.jiolocal.R

class TopBarLocationUpdate : Fragment() {

    private val TAG = "TopBarLocationUpdate"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    lateinit  var fragmentContainer : FragmentContainerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentContainer = activity!!.findViewById(R.id.bottomDialogFragment) as FragmentContainerView
        return inflater.inflate(R.layout.fragment_top_bar_location_update, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layout = view.findViewById<ConstraintLayout>(R.id.topBarLay)
        layout.setOnClickListener {
            Log.e(TAG, "onViewCreated: clicked" )
            activity!!.supportFragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(fragmentContainer.id, LocationCaptureAndCheckDialog()).commit()
        }
    }

}