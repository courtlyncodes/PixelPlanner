package com.example.pixelplanner.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.pixelplanner.model.TaskItem
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    /**
     *  Observes list of tasks.
     *
     *  @return all tasks in the database.
     */
    @Query("SELECT * FROM tasks")
    fun observeAllTasks(): Flow<List<TaskItem>>

    /**
     *  Selects a single task.
     *
     *  @param id the id of the task.
     *  @return the task with the given id.
     */
    @Query("SELECT * FROM tasks WHERE id = :id")
    fun getById(id: Long): Flow<TaskItem?>

    /**
     *  Adds a task to the database.
     *
     *  @param task the task to add.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: TaskItem)

    /**
     *  Updates a task in the database.
     *
     *  @param task the task to update.
     */
    @Update
    suspend fun updateTask(task: TaskItem)

    /**
     * Deletes a task from the database.
     */
    @Delete
    suspend fun deleteById(task: TaskItem)
}
