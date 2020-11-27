package com.example.jiolocal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import com.example.jiolocal.fragment.LocalDashBoardFragment
import com.example.jiolocal.fragment.LocationCaptureAndCheckDialog
import com.example.jiolocal.fragment.TopBarLocationUpdate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, LocalDashBoardFragment()).commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.locationDisplay, TopBarLocationUpdate()).commit()


        //check for pin code if correct ok otherwise just show dialog
        var pinCollected = true
        if(!pinCollected){
            supportFragmentManager.beginTransaction()
                .replace(R.id.bottomDialogFragment, LocationCaptureAndCheckDialog()).commit()
        }
    }
}