package com.example.pixelplanner

import android.app.Application
import com.example.pixelplanner.data.AppContainer
import com.example.pixelplanner.data.AppDataContainer

class PixelPlannerApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}