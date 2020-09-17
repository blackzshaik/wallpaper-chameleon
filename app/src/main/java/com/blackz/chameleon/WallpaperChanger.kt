package com.blackz.chameleon

import android.app.WallpaperManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.Toast

class WallpaperChanger : BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
        val msg = "Wallpaper changed ${System.currentTimeMillis()/1000}"

        val am = p0?.assets
        val img = am?.open(WallpaperChooser.getName())
        val bmp = BitmapFactory.decodeStream(img)
        val wpManager = WallpaperManager.getInstance(p0)
        wpManager.setBitmap(bmp)
//      For testing
//      Toast.makeText(p0,msg,Toast.LENGTH_SHORT).show()

        Log.d("WallpaperChanger",msg)
    }

}