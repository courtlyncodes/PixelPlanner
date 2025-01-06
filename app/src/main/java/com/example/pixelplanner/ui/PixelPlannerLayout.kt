package com.example.pixelplanner.ui

import androidx.activity.compose.BackHandler
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pixelplanner.model.Task
import com.example.pixelplanner.ui.taskdetail.TaskDetailPane
import com.example.pixelplanner.ui.tasklist.TaskListPane
import com.example.pixelplanner.ui.tasklist.TaskListViewModel

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun AppLayout(
    onAddNewClick: () -> Unit,
    onEditClick: (Task) -> Unit,
    viewModel: TaskListViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val navigator = rememberListDetailPaneScaffoldNavigator<Nothing>()
    val tasks by viewModel.taskList.collectAsState()

    BackHandler(navigator.canNavigateBack()) {
        navigator.navigateBack()
    }
    ListDetailPaneScaffold(
        directive = navigator.scaffoldDirective,
        value = navigator.scaffoldValue,
        listPane = {
            TaskListPane(
                tasks = tasks.tasks,
                onAddNewClick = { onAddNewClick() },
                onItemClick = { navigator.navigateTo(ListDetailPaneScaffoldRole.Detail) }
            )
        },
        detailPane = { TaskDetailPane(onEditClick = { onEditClick(it) }) }
    )
}
