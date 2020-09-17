package com.blackz.chameleon

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.res.AssetManager
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val alarmManager:AlarmManager by lazy {
        getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }
    private lateinit var pendingIntent:PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpCurrentImage()
        setUpAlarmManager()
        setUpFakeCheckBox()
    }

    fun setUpCurrentImage(){
        val am = this.assets
        val imageName = WallpaperChooser.getName()
        //FIXME; Implement thread/coroutines for better performance
        val img = am.open(imageName)
        val d = Drawable.createFromStream(img,imageName)
        imageView.setImageDrawable(d)

    }

    private fun setUpAlarmManager(){
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this,WallpaperChanger::class.java)
        pendingIntent = PendingIntent.getBroadcast(this,423,intent,0)
        val time = Calendar.getInstance()
        time.timeInMillis = System.currentTimeMillis()
        time.add(Calendar.SECOND,10)
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),AlarmManager.INTERVAL_HOUR,pendingIntent)

    }

    private fun setUpFakeCheckBox() {
        switch1.setOnCheckedChangeListener { _, b ->
            if(!b){
                alarmManager.cancel(pendingIntent)
            }
        }
    }
}
