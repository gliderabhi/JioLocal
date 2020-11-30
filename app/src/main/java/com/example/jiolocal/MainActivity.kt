package com.example.jiolocal

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import com.example.jiolocal.fragment.LocalDashBoardFragment
import com.example.jiolocal.fragment.LocationCaptureAndCheckDialog
import com.example.jiolocal.fragment.ServiceDetailsPage
import com.example.jiolocal.fragment.TopBarLocationUpdate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val PERMISSIONS_REQUEST_CODE = 1234
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //check permissions
        val permissions : List<String> = listOf(
            Manifest.permission.CALL_PHONE,
            Manifest.permission.ACCESS_FINE_LOCATION
        )

        if(checkAndRequestPermissions()){
            //initApp()
        }
        val frag = LocalDashBoardFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, frag).commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.locationDisplay, TopBarLocationUpdate()).commit()


        //check for pin code if correct ok otherwise just show dialog
        var pinCollected = true
        if(!pinCollected){
            supportFragmentManager.beginTransaction()
                .replace(R.id.bottomDialogFragment, LocationCaptureAndCheckDialog()).commit()
        }


    }

    private fun checkAndRequestPermissions(): Boolean {
        val permissionsNeeded = ArrayList<String>()
        for(perm in permissionsNeeded) {
            //if(applicationContext.checkSelfPermission(perm)!=PackageManager.PERMISSION_GRANTED)
        }

        return false
    }

    override fun onBackPressed() {
       // super.onBackPressed()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, LocalDashBoardFragment()).commitNow()
        supportFragmentManager.beginTransaction()
            .replace(R.id.locationDisplay, TopBarLocationUpdate()).commit()

        findViewById<FragmentContainerView>(R.id.locationDisplay).visibility = View.VISIBLE

    }
}