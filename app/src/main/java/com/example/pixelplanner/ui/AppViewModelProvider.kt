package com.example.pixelplanner.ui

import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pixelplanner.ui.tasklist.TaskListViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            TaskListViewModel(

            )
        }

    }
}