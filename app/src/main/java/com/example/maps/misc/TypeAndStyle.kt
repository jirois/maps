package com.example.maps.misc

import android.content.Context
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.maps.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MapStyleOptions

class TypeAndStyle {

    fun setMapStyle(googleMap: GoogleMap, context: Context){
        try{
            val success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    context,
                    R.raw.style)
            )
            if (!success){
                Log.d("Maps", "failed to add style")
            }
        }catch (e: Exception){
            Log.d("Maps", e.stackTrace.toString())

        }
    }
    fun setMapType(item: MenuItem,mMap: GoogleMap ){
        when(item.itemId) {
            R.id.normal -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
            }
            R.id.hybrid -> {
                mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
            }
            R.id.satellite -> {
                mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
            }
            R.id.terrain -> {
                mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
            }
            R.id.none -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NONE
            }
        }
    }
}