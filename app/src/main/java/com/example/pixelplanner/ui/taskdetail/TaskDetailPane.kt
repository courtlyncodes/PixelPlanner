package com.example.pixelplanner.ui.taskdetail

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
    onEditClick: (Task) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: TaskListViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val task = viewModel.task.collectAsState().value

    Scaffold(
        topBar = {
            Text(text = task?.title ?: "")
        }
    ) {
        Column(modifier = modifier.padding(it)) {
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
                    Column(modifier = Modifier.padding(16.dp)) {
                        if (task != null) {
                            Text(task.title)
                        }
                        if (task != null) {
                            Text(task.description)
                        }
                    }
//            Column(){
//                Text(toDoItem.dueDate)
//            }
                }
            }
            Row {
                Button(onClick = { viewModel.deleteTask(task!!) }) {
                    Text(text = stringResource(R.string.delete))
                }
                Button(onClick = {
                    if (task != null) {
                        onEditClick(task)
                    }
                }) {
                    Text(text = stringResource(R.string.edit))
                }
            }
        }
}
}