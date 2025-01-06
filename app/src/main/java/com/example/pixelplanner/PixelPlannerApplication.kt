package com.example.pixelplanner

import android.app.Application
import com.example.pixelplanner.data.AppContainer
import com.example.pixelplanner.data.AppDataContainer
import com.example.pixelplanner.data.TaskDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PixelPlannerApplication : Application() {

    lateinit var container: AppContainer

    // Lazy initialization of the database
    val db: TaskDatabase by lazy {
        TaskDatabase.getDatabase(this) // Replace with your actual database initialization method
    }

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)

     /*   CoroutineScope(Dispatchers.IO).launch {
            resetDatabase()
        }*/
    }

    private suspend fun resetDatabase() {
        db.taskDao().resetTable() // Clear table and reset primary key
    }
}