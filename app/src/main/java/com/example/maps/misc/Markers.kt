package com.example.maps.misc

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.Marker

class Markers {
//    fun fromVectorToBitmap(id: Int, color: Int): BitmapDescriptor {
//        val vectorDrawable: Drawable? = ResourcesCompat.getDrawable(re,id,null)
//        if (vectorDrawable == null){
//            Log.d("MapActivity", "Not Found")
//            return BitmapDescriptorFactory.defaultMarker()
//        }
//        val bitmap = Bitmap.createBitmap(
//            vectorDrawable.intrinsicWidth,
//            vectorDrawable.intrinsicHeight,
//            Bitmap.Config.ARGB_8888
//        )
//        val canvas = Canvas(bitmap)
//        vectorDrawable.setBounds(0,0,canvas.width, canvas.height)
//        DrawableCompat.setTint(vectorDrawable, color)
//        vectorDrawable.draw(canvas)
//        return BitmapDescriptorFactory.fromBitmap(bitmap)
//    }

//    fun onMapLongCLick(){
//        mMap.setOnMapLongClickListener {
//            Toast.makeText(this, "${it.latitude}, ${it.longitude}", Toast.LENGTH_LONG).show()
//        }
//    }
//
//    override fun onMarkerClick(marker: Marker): Boolean {
//        mMap.animateCamera(CameraUpdateFactory.zoomTo(15f),2000,null)
//        marker.showInfoWindow()
//        return true
//    }


}