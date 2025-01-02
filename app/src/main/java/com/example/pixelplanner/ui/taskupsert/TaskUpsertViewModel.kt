package com.example.pixelplanner.ui.taskupsert

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pixelplanner.TaskUpsertDestination
import com.example.pixelplanner.data.TaskRepository
import com.example.pixelplanner.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class TaskUpsertUiState(
    val task: Task = Task(
        title = "",
        description = "",
//        dueDate = LocalDate.of(2025, 1, 1)
    )
)

class TaskUpsertViewModel(
    savedStateHandle: SavedStateHandle,
    private val taskRepository: TaskRepository
) : ViewModel() {

    private val _task = MutableStateFlow(TaskUpsertUiState())
    val task: StateFlow<TaskUpsertUiState> = _task.asStateFlow()

    private val taskId: Long? = savedStateHandle[TaskUpsertDestination.TASK_ID_ARG]

    // Initialize the ViewModel to get a note by its ID
    init {
        viewModelScope.launch {
            taskRepository.getTaskStream(taskId!!)
                .filterNotNull()
                .collect { task ->
                    _task.value = TaskUpsertUiState(task)
                }
        }
    }

    private fun updateTask(task: Task) {
        try {
            _task.update { it.copy(task = task) }
        } catch (e: Exception) {
            Log.e(TAG, "Error updating task: ${e.message}")
        }
    }

    fun upsertTaskTitle(title: String) {
        try {
            updateTask(_task.value.task.copy(title = title))
            viewModelScope.launch {
                taskRepository.upsertTask(task.value.task.copy(title = title))
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error updating task title: ${e.message}")
        }
    }

    fun upsertTaskDescription(description: String) {
        try {
            updateTask(_task.value.task.copy(description = description))
            viewModelScope.launch {
                taskRepository.upsertTask(task.value.task.copy(description = description))
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error updating task description: ${e.message}")
        }
    }

    fun deleteTask() {
        try {
            viewModelScope.launch {
                taskRepository.deleteTask(task.value.task)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error deleting task: ${e.message}")
        }
    }

    companion object {
        private const val TAG = "TaskUpsertViewModel"
    }


    //upsert
    //delete
}