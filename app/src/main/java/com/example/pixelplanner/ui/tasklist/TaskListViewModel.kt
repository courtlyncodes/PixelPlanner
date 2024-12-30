package com.example.pixelplanner.ui.tasklist

import androidx.lifecycle.ViewModel
import com.example.pixelplanner.model.TaskItem

class TaskListViewModel: ViewModel() {
    private val _taskItems = mutableListOf<TaskItem>()
    val taskItems: List<TaskItem> = _taskItems
}