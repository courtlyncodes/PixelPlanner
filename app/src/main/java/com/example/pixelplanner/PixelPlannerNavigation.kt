package com.example.pixelplanner

interface NavigationDestination {
    val route: String
}

object TaskUpsertDestination : NavigationDestination {
    override val route = "task_upsert"
    private const val taskIdArg = "taskId"
    val routeWithArgs = "$route/{$taskIdArg}"
}
