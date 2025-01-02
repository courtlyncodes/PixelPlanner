package com.example.pixelplanner.ui.tasklist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pixelplanner.data.TaskRepository
import com.example.pixelplanner.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class TaskListUiState(
    val tasks: List<Task> = emptyList()
)

class TaskListViewModel(private val taskRepository: TaskRepository): ViewModel() {

    private val _task = MutableStateFlow<Task?>(null)
    val task: StateFlow<Task?> = _task

    val taskList: StateFlow<TaskListUiState> =
        taskRepository.getTasksStream().map { TaskListUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = TaskListUiState()
            )

    fun deleteTask(task: Task) {
        try {
            viewModelScope.launch {
                taskRepository.deleteTask(task)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error deleting task: ${e.message}")
        }
    }

    companion object {
        private const val TAG = "TaskListViewModel"
    }
}

//    delete?