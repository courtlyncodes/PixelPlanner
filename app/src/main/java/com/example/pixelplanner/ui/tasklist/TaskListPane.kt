package com.example.pixelplanner.ui.tasklist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pixelplanner.R
import com.example.pixelplanner.model.TaskItem
import com.example.pixelplanner.ui.theme.PixelPlannerTheme

@Composable
fun TaskList(taskItems: List<TaskItem>, onAddNewClick: () -> Unit, onItemClick: (TaskItem) -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            Text(text = "To-Do List")
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
        Column(modifier = modifier.padding(it).padding(16.dp)) {
            taskItems.forEach { toDoItem ->
                TaskCard(toDoItem, onItemClick = { onItemClick(toDoItem) })
            }
        }
    }
}

@Composable
fun TaskCard(taskItem: TaskItem, onItemClick: (TaskItem) -> Unit, modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier.clickable { onItemClick(taskItem) },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        var checked by remember { mutableStateOf(false) }

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column {
                Checkbox(checked = checked, onCheckedChange = { checked = it })
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(taskItem.title)
                Text(taskItem.description)
            }
        }
    }
}

@Preview
@Composable
fun ToDoListPreview() {
    PixelPlannerTheme {
        val taskItem = TaskItem(1, "Title", "Description")
        val taskItems = listOf(
            TaskItem(1, "Title", "Description"),
            TaskItem(2, "Title", "Description"),
            TaskItem(3, "Title", "Description")
        )
        TaskList(taskItems, onAddNewClick = {}, onItemClick = {})
    }
}

@Preview
@Composable
fun ToDoItemCardPreview() {
    PixelPlannerTheme {
        val taskItem = TaskItem(1, "Title", "Description")
        TaskCard(taskItem, onItemClick = {})
    }
}
