package com.example.pixelplanner.ui.tasklist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pixelplanner.model.TaskItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TaskListViewModel: ViewModel() {
    private val _taskItems = mutableListOf<TaskItem>()
    val taskItems: List<TaskItem> = _taskItems

    private val _selectedTaskItem = MutableStateFlow<TaskItem?>(null)
    val selectedTaskItem: StateFlow<TaskItem?> = _selectedTaskItem
}