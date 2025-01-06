package com.example.pixelplanner.ui.taskdetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pixelplanner.TaskUpsertDestination
import com.example.pixelplanner.data.TaskRepository
import com.example.pixelplanner.model.Task
import com.example.pixelplanner.ui.taskupsert.TaskUpsertUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

data class TaskDetailUiState(
    val task: Task = Task(
        title = "",
        description = "",
//        dueDate = LocalDate.of(2025, 1, 1)
    )
)

//class TaskDetailViewModel(savedStateHandle: SavedStateHandle, private val taskRepository: TaskRepository): ViewModel() {
//
//    private val _task = MutableStateFlow(TaskDetailUiState())
//    val task: StateFlow<TaskDetailUiState> = _task.asStateFlow()
//
////    private val taskId: Long? = savedStateHandle[TaskDetailDestination.TASK_ID_ARG]
//
//    // Initialize the ViewModel to get a note by its ID
//    init {
//        viewModelScope.launch {
//            if (taskId != null) {
//                taskRepository.getTaskStream(taskId)
//                    .filterNotNull()
//                    .collect { task ->
//                        _task.value = TaskDetailUiState(task)
//                    }
//            }
//        }
//    }
//}