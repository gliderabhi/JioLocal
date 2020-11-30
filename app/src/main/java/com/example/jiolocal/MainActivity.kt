package com.example.jiolocal

import android.Manifest
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import com.example.jiolocal.fragment.LocalDashBoardFragment
import com.example.jiolocal.fragment.LocationCaptureAndCheckDialog
import com.example.jiolocal.fragment.TopBarLocationUpdate


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

        checkAndRequestPermissions()
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
        val permissionsNeeded =
            ArrayList<String>()

        val permissionsList = ArrayList<String>()
        if (!permissionsList.contains(
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        ) {
            permissionsNeeded.add("GPS")
            permissionsList.add(
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        }
        if (!permissionsList.contains(Manifest.permission.CALL_PHONE)
        ) {
            permissionsNeeded.add("Calling")
            permissionsList.add(
                Manifest.permission.CALL_PHONE
            )
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (permissionsList.isNotEmpty()) {
                if (permissionsNeeded.size > 0) {
                    var message = " You need permissions for ${permissionsNeeded[0]}"
                    for (i in 1 until permissionsNeeded.size)
                        message = message.toString() + ", " + permissionsNeeded[i]
                    AlertDialog.Builder(this).setTitle(message)
                        .setPositiveButton("Ok ") { _, _ ->

                            requestPermissions(
                                permissionsList.toTypedArray(),
                                PERMISSIONS_REQUEST_CODE
                            )

                        }
                    requestPermissions(permissionsList.toTypedArray(), PERMISSIONS_REQUEST_CODE)
                }
            }
        }
        return false

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSIONS_REQUEST_CODE -> {
                val perms: MutableMap<String, Int> =
                    HashMap()
                // Initial
                perms[Manifest.permission.ACCESS_FINE_LOCATION] = PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.READ_CONTACTS] = PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.WRITE_CONTACTS] = PackageManager.PERMISSION_GRANTED
                // Fill with results
                var i = 0
                while (i < permissions.size) {
                    perms[permissions[i]] = grantResults[i]
                    i++
                }
                // Check for ACCESS_FINE_LOCATION
                if (perms[Manifest.permission.ACCESS_FINE_LOCATION] == PackageManager.PERMISSION_GRANTED && perms[Manifest.permission.READ_CONTACTS] == PackageManager.PERMISSION_GRANTED && perms[Manifest.permission.WRITE_CONTACTS] == PackageManager.PERMISSION_GRANTED
                ) {
                    // All Permissions Granted
                    //good lets get to work
                } else {
                    // Permission Denied
                    Toast.makeText(
                        this@MainActivity,
                        "Some Permission is Denied",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    override fun onBackPressed() {
       // super.onBackPressed()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, LocalDashBoardFragment()).commitNow()
        supportFragmentManager.beginTransaction()
            .replace(R.id.locationDisplay, TopBarLocationUpdate()).commit()

        findViewById<FragmentContainerView>(R.id.locationDisplay).visibility = View.VISIBLE

    }
}