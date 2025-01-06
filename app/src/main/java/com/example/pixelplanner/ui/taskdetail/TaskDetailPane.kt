package com.example.pixelplanner.ui.taskdetail

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pixelplanner.R
import com.example.pixelplanner.model.Task
import com.example.pixelplanner.ui.AppViewModelProvider
import com.example.pixelplanner.ui.tasklist.TaskListViewModel

@Composable
fun TaskDetailPane(
    task: Task,
    onEditClick: (Task) -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: TaskListViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {

    Scaffold(
        topBar = {
            Text(text = task.title ?: "")
        }
    ) { paddingValues ->
        Column(modifier = modifier.padding(paddingValues)) {
            ElevatedCard(
                modifier = modifier,
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceVariant)
            ) {
                var checked by remember { mutableStateOf(false) }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Checkbox(checked = checked, onCheckedChange = { checked = it })
                    }
                    Log.d("TaskDetailPane", "Task title: ${task.title}")
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(task.title)
                        Text(task.description)
                    }
//            Column(){
//                Text(toDoItem.dueDate)
//            }
                }
            }
            Row {
                Button(onClick = {
                    viewModel.deleteTask()
                    navigateUp()
                }
                ) {
                    Text(text = stringResource(R.string.delete))
                }
                Button(onClick = {
                    onEditClick(task)
                }) {
                    Text(text = stringResource(R.string.edit))
                }
            }
        }
}
}