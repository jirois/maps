package com.example.maps.misc

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory

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

}