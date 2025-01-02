package com.example.pixelplanner.ui.tasklist

import androidx.lifecycle.ViewModel
import com.example.pixelplanner.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TaskListViewModel: ViewModel() {
    private val _tasks = mutableListOf<Task>()
    val tasks: List<Task> = _tasks

    private val _selectedTask = MutableStateFlow<Task?>(null)
    val selectedTask: StateFlow<Task?> = _selectedTask
}