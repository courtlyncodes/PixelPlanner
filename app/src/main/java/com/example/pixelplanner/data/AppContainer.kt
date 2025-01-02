package com.example.pixelplanner.data

import android.content.Context

interface AppContainer {
    val taskRepository: TaskRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val taskRepository: TaskRepository by lazy {
        DefaultTaskRepository(TaskDatabase.getDatabase(context).taskDao())
    }
}