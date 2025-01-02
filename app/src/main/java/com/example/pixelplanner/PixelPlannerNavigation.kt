package com.example.pixelplanner

interface NavigationDestination {
    val route: String
}

object TaskListDestination : NavigationDestination {
    override val route = "task_list"
}

object TaskUpsertDestination : NavigationDestination {
    override val route = "task_upsert"
    const val TASK_ID_ARG = "taskId"
    val routeWithArgs = "$route/{$TASK_ID_ARG}"
}
