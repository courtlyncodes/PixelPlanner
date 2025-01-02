package com.example.pixelplanner.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pixelplanner.model.TaskItem

@Database(entities = [TaskItem::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var Instance: TaskDatabase? = null
    }

    fun getDatabase(context: Context): TaskDatabase {
        // Check if the Instance of the database already exists.
        // If it does, return the existing instance.
        return Instance ?: synchronized(this) {
            // If Instance is null, synchronize this block to ensure only one thread at a time can access it.
            Instance ?: Room.databaseBuilder(
                // Provide the application context to the Room database builder.
                context,
                // Specify the database class (TaskDatabase) that represents the database schema.
                TaskDatabase::class.java,
                // Provide a name for the database file, "task_database" in this case.
                "task_database"
            )
                // Build the database object. This prepares Room to create or open the database.
                .build()
                // After the database is built, assign it to the Instance variable.
                .also { Instance = it }
        }
    }
}