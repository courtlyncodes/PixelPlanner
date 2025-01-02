package com.example.pixelplanner.data

import com.example.pixelplanner.model.Task
import kotlinx.coroutines.flow.Flow

class DefaultTaskRepository (private val taskDao: TaskDao) : TaskRepository {
    override fun getTasksStream(): Flow<List<Task>> = taskDao.observeAllTasks()

    override fun getTaskStream(id: Long): Flow<Task?> = taskDao.getTask(id)

    override suspend fun upsertTask(task: Task) = taskDao.upsertTask(task)

    override suspend fun deleteTask(task: Task) = taskDao.deleteById(task)

}