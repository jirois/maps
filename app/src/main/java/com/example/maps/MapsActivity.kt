package com.example.maps


import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.lifecycle.lifecycleScope

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.example.maps.databinding.ActivityMapsBinding
import com.example.maps.misc.CameraAndViewport
import com.example.maps.misc.Markers
import com.example.maps.misc.TypeAndStyle
import com.google.android.gms.maps.model.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private val typeAndStyle by lazy { TypeAndStyle() }
    private val cameraAndViewport by lazy { CameraAndViewport() }
    private val customMarkers by lazy { Markers() }

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
        val akpbuyo = LatLng(4.98823,	8.39793)
        val calabarMarker = mMap.addMarker(MarkerOptions()
            .position(calabar)
            .title("Marker in calabar")
            .snippet("Some of the propose Locations")
        )
        val akpbuyoMarker = mMap.addMarker(MarkerOptions()
            .position(akpbuyo)
            .title("Marker in akpbuyo")
            .snippet("Some of the propose Locations")
            .zIndex(1f)
        )

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(calabar, 10f))
//        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraAndViewport.caliBar))
        mMap.uiSettings.apply {
            isZoomControlsEnabled = true
        }
        typeAndStyle.setMapStyle(mMap,this)

        onMapLongCLick()
        mMap.setOnMarkerClickListener(this)




//        lifecycleScope.launch {
//            delay(4000L)
//            calabarMarker?.remove()
//
//        }




    }

    fun onMapLongCLick(){
        mMap.setOnMapLongClickListener {
            Toast.makeText(this, "${it.latitude}, ${it.longitude}", Toast.LENGTH_LONG).show()
        }
    }

    override fun onMarkerClick(marker: Marker): Boolean {
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15f),2000,null)
        marker.showInfoWindow()
        return true
    }


}