package com.example.pixelplanner.ui

import androidx.activity.compose.BackHandler
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.pixelplanner.ui.taskdetail.TaskDetailCard
import com.example.pixelplanner.ui.tasklist.TaskList
import com.example.pixelplanner.ui.tasklist.TaskListViewModel

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun AppLayout(
    taskListViewModel: TaskListViewModel
) {
    val navigator = rememberListDetailPaneScaffoldNavigator<Nothing>()
    val taskList = taskListViewModel.tasks
    val taskItem by taskListViewModel.task.collectAsState()

    BackHandler(navigator.canNavigateBack()) {
        navigator.navigateBack()
    }
    ListDetailPaneScaffold(
        directive = navigator.scaffoldDirective,
        value = navigator.scaffoldValue,
        listPane = {
            TaskList(
                tasks = taskList,
                onAddNewClick = { },
                onItemClick = { navigator.navigateTo(ListDetailPaneScaffoldRole.Detail) }
            )
        },
        detailPane = { taskItem?.let { TaskDetailCard(task = it) } }
    )
}
