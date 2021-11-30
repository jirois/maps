package com.example.maps.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class CameraAndViewport {
    val caliBar: CameraPosition = CameraPosition.builder()
        .target(LatLng(8.43793,	4.93379))
        .zoom(17f)
        .bearing(100f)
        .tilt(45f)
        .build()
}