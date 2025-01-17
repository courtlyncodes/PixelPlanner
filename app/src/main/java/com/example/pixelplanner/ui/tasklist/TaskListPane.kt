package com.example.pixelplanner.ui.tasklist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pixelplanner.R
import com.example.pixelplanner.model.Task
import com.example.pixelplanner.ui.AppViewModelProvider
import com.example.pixelplanner.ui.theme.PixelPlannerTheme

@Composable
fun TaskListPane(
    tasks: List<Task>,
    onAddNewClick: () -> Unit,
    onItemClick: (Task) -> Unit,
    modifier: Modifier = Modifier
) {

    Scaffold(
        topBar = {
            Text(text = stringResource(R.string.to_do_list))
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onAddNewClick() },
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary,
                shape = CircleShape,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(Icons.Filled.Add, stringResource(R.string.add_new_note))
            }
        }
    ) {
        LazyColumn(modifier = modifier
            .padding(it)
            .padding(16.dp)) {
            items(tasks.size) { index ->
                TaskCard(task = tasks[index], onItemClick = { task -> onItemClick(task) })
            }
        }
    }
}

@Composable
fun TaskCard(
    task: Task,
    onItemClick: (Task) -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier.clickable { onItemClick(task) },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        var checked by remember { mutableStateOf(false) }

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column {
                Checkbox(checked = checked, onCheckedChange = { checked = it })
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(task.title)
                Text(task.description)
            }
        }
    }
}

//@Preview
//@Composable
//fun ToDoListPreview() {
//    PixelPlannerTheme {
//        val task = Task(1, "Title", "Description")
//        val tasks = listOf(
//            Task(1, "Title", "Description"),
//            Task(2, "Title", "Description"),
//            Task(3, "Title", "Description")
//        )
//        TaskListPane(onAddNewClick = {}, onItemClick = {})
//    }
//}
//
//@Preview
//@Composable
//fun ToDoItemCardPreview() {
//    PixelPlannerTheme {
//        val task = Task(1, "Title", "Description")
//        TaskCard(task, onItemClick = {})
//    }
//}
