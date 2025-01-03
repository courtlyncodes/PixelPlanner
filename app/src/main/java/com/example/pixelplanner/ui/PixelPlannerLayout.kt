package com.example.pixelplanner.ui

import androidx.activity.compose.BackHandler
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import com.example.pixelplanner.ui.taskdetail.TaskDetailPane
import com.example.pixelplanner.ui.tasklist.TaskListPane

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun AppLayout(
    onAddNewClick: () -> Unit
) {
    val navigator = rememberListDetailPaneScaffoldNavigator<Nothing>()

    BackHandler(navigator.canNavigateBack()) {
        navigator.navigateBack()
    }
    ListDetailPaneScaffold(
        directive = navigator.scaffoldDirective,
        value = navigator.scaffoldValue,
        listPane = {
            TaskListPane(
                onAddNewClick = { onAddNewClick() },
                onItemClick = { navigator.navigateTo(ListDetailPaneScaffoldRole.Detail) }
            )
        },
        detailPane = { TaskDetailPane() }
    )
}
