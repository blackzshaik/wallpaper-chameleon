package com.blackz.chameleon

import android.util.Log
import java.util.*

object WallpaperChooser {
    fun getName():String{
        val calendar = Calendar.getInstance()
        return when (calendar.get(Calendar.HOUR_OF_DAY)) {
            in 5..6 -> "0600.jpg"
            in 6..10 -> "1000.jpg"
            in 10..12 -> "1200.jpg"
            in 12..15 -> "1500.jpg"
            in 15..18 -> "1800.jpg"
            in 18..21 -> "2100.jpg"
            else -> "0000.jpg"
        }
    }
}