package com.example.pixelplanner.ui

import androidx.activity.compose.BackHandler
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import com.example.pixelplanner.model.TaskItem
import com.example.pixelplanner.ui.tasklist.TaskList

//@OptIn(ExperimentalMaterial3AdaptiveApi::class)
//@Composable
//fun AppLayout() {
//    val navigator = rememberListDetailPaneScaffoldNavigator<TaskItem>()
//
//    BackHandler(navigator.canNavigateBack()) {
//        navigator.navigateBack()
//    }
//    ListDetailPaneScaffold(
//        directive = navigator.scaffoldDirective,
//        listPane = { TaskList() },
//        detailPane = { TaskDetailPane() }
//            )
//}