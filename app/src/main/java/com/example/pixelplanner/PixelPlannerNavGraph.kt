package com.example.pixelplanner

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pixelplanner.ui.AppLayout
import com.example.pixelplanner.ui.tasklist.TaskListPane
import com.example.pixelplanner.ui.taskupsert.TaskUpsertPane

@Composable
fun PixelPlannerNavGraph(
    navController: NavHostController = rememberNavController(),

    ) {
    val startDestination: String = TaskListDestination.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(TaskListDestination.route) {
            AppLayout(
                onAddNewClick = { navController.navigate(TaskUpsertDestination.route) },
                onEditClick = { task ->
                    navController.navigate("${TaskUpsertDestination.route}/${task.id}")
                }
            )
        }
        composable(TaskUpsertDestination.routeWithoutArgs) {
            TaskUpsertPane(onSaveClick = { navController.navigateUp() })
        }
        composable(
            TaskUpsertDestination.routeWithArgs,
            arguments = listOf(navArgument(TaskUpsertDestination.TASK_ID_ARG) {
                type = NavType.LongType
            }
            )
        ) {
            TaskUpsertPane(onSaveClick = { navController.navigateUp() })

        }

    }

}