package com.example.pixelplanner.ui.taskdetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pixelplanner.model.TaskItem

class TaskDetailViewModel: ViewModel() {
    private val _taskItem = mutableStateOf<TaskItem?>(null)
    val taskItem: State<TaskItem?> = _taskItem

}