package com.example.pixelplanner.data

import com.example.pixelplanner.model.Task
import kotlinx.coroutines.flow.Flow

/**
 * Interface to the data layer.
 */
interface TaskRepository {
    fun getTasksStream(): Flow<List<Task>>
    fun getTaskStream(id: Long): Flow<Task?>
    suspend fun upsertTask(task: Task)
    suspend fun deleteTask(task: Task)
}