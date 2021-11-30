package com.example.maps


import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.maps.databinding.ActivityMapsBinding
import com.example.maps.misc.CameraAndViewport
import com.example.maps.misc.TypeAndStyle
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.Marker
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapsActivity : AppCompatActivity(), OnMapReadyCallback,GoogleMap.OnMarkerDragListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private val typeAndStyle by lazy { TypeAndStyle() }
    private val cameraAndViewport by lazy { CameraAndViewport() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.map_type, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        typeAndStyle.setMapType(item, mMap)
        return true
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val calabar = LatLng(4.93379,	8.43793)
        val calabarMarker = mMap.addMarker(MarkerOptions().position(calabar).title("Marker in calabar").draggable(true))
       calabarMarker?.tag = "Restaurant"
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(calabar, 10f))
//        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraAndViewport.caliBar))
        mMap.uiSettings.apply {
            isZoomControlsEnabled = true
        }
        typeAndStyle.setMapStyle(mMap,this)




//        lifecycleScope.launch {
//            delay(4000L)
//            calabarMarker?.remove()
//
//        }

    }

    override fun onMarkerDrag(marker: Marker) {
        Log.d("Drag", "Start")

    }

    override fun onMarkerDragEnd(marker: Marker) {
        Log.d("Drag", "drag")
        marker.position

    }

    override fun onMarkerDragStart(p0: Marker) {
        Log.d("Drag", "End")

    }


}