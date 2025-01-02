package com.example.pixelplanner.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pixelplanner.PixelPlannerApplication
import com.example.pixelplanner.ui.tasklist.TaskListViewModel
import com.example.pixelplanner.ui.taskupsert.TaskUpsertViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            TaskListViewModel(
                pixelPlannerApplication().container.taskRepository
            )
        }
        initializer {
            TaskUpsertViewModel(
                this.createSavedStateHandle(),
                pixelPlannerApplication().container.taskRepository
            )
        }
    }
}

fun CreationExtras.pixelPlannerApplication(): PixelPlannerApplication = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PixelPlannerApplication)