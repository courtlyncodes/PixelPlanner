package com.example.pixelplanner.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import androidx.room.Upsert
import com.example.pixelplanner.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    /**
     *  Observes list of tasks.
     *
     *  @return all tasks in the database.
     */
    @Query("SELECT * FROM tasks")
    fun observeAllTasks(): Flow<List<Task>>

    /**
     *  Selects a single task.
     *
     *  @param id the id of the task.
     *  @return the task with the given id.
     */
    @Query("SELECT * FROM tasks WHERE id = :id")
    fun getTask(id: Long): Flow<Task?>

    /**
     *  Inserts or updates a task in the database. If a task with the same id already exists, replace it.
     *
     *  @param task the task to insert or update.
     */
    @Upsert
    suspend fun upsertTask(task: Task)

    /**
     * Deletes a task from the database.
     */
    @Delete
    suspend fun deleteById(task: Task)

    @Query("DELETE FROM tasks")
    suspend fun clearTable()

    @Query("DELETE FROM sqlite_sequence WHERE name = 'tasks'")
    suspend fun resetPrimaryKey()

    @Transaction
    suspend fun resetTable() {
        clearTable()
        resetPrimaryKey()
    }
}
