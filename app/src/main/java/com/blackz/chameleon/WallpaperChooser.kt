package com.blackz.chameleon

import android.util.Log
import java.util.*

object WallpaperChooser {
    fun getName():String{
        val calendar = Calendar.getInstance()
        return when (calendar.get(Calendar.HOUR_OF_DAY)) {
            6 -> "0600.jpg"
            7 -> "0700.jpg"
            8 -> "0800.jpg"
            9 -> "0900.jpg"
            10 -> "1000.jpg"
            11 -> "1100.jpg"
            12 -> "1200.jpg"
            13 -> "1300.jpg"
            14 -> "1400.jpg"
            15 -> "1500.jpg"
            16 -> "1600.jpg"
            17 -> "1700.jpg"
            18 -> "1800.jpg"
            19 -> "1900.jpg"
            20 -> "2000.jpg"
            in 21..23 -> "2100.jpg"
            else -> "0000.jpg"
        }
    }
}