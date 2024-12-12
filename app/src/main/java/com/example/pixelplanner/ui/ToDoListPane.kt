package com.example.pixelplanner.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.pixelplanner.model.ToDoItem

@Composable
fun ToDoList(toDoItems: List<ToDoItem>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        toDoItems.forEach { toDoItem ->
            ToDoItemCard(toDoItem)
        }
    }
}

@Composable
fun ToDoItemCard(toDoItem: ToDoItem, modifier: Modifier = Modifier) {
    OutlinedCard(modifier = modifier, colors = CardDefaults.cardColors(Color.LightGray)) {
        var checked by remember { mutableStateOf(true) }
        Row {
            Column {
                Checkbox(checked = checked, onCheckedChange = { checked = it })
            }
            Column {
                Text(toDoItem.title)
                Text(toDoItem.description)
            }
//            Column(){
//                Text(toDoItem.dueDate)
//            }
        }
    }
}

@Preview
@Composable
fun ToDoListPreview() {
    val toDoItems = listOf(
        ToDoItem(1, "Title", "Description"),
        ToDoItem(2, "Title", "Description"),
        ToDoItem(3, "Title", "Description")
    )
    ToDoList(toDoItems)
}

@Preview
@Composable
fun ToDoItemCardPreview() {
    val toDoItem = ToDoItem(1, "Title", "Description")
    ToDoItemCard(toDoItem)
}
