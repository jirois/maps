package com.example.maps.misc

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.TextView
import com.example.maps.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class CustomAdapterInfo(context: Context): GoogleMap.InfoWindowAdapter {
    private val contentView = (context as Activity).layoutInflater.inflate(R.layout.custom_info_window, null)
    override fun getInfoContents(marker: Marker): View? {
        renderView(marker, contentView)
        return contentView
    }

    override fun getInfoWindow(marker: Marker): View? {
        renderView(marker, contentView)
        return contentView
    }

    private fun renderView(marker:Marker?, contentView: View){
        val title = marker?.title
        val desc = marker?.snippet

        val titleView = contentView.findViewById<TextView>(R.id.tv_title_info)
        titleView.text = title

        val descView = contentView.findViewById<TextView>(R.id.tv_desc_info)
        descView.text = desc
    }
}