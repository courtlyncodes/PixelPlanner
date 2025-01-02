package com.example.pixelplanner.ui.taskdetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pixelplanner.model.Task

class TaskDetailViewModel: ViewModel() {
    private val _task = mutableStateOf<Task?>(null)
    val task: State<Task?> = _task

}