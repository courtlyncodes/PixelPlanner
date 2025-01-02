package com.example.pixelplanner.ui.taskupsert

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pixelplanner.R
import com.example.pixelplanner.ui.theme.PixelPlannerTheme

@Composable
fun TaskUpsertPane() {
    Scaffold(
        topBar = {
            Text(text = stringResource(R.string.task_details))
        },
        floatingActionButton = {
            Button(colors = ButtonColors(MaterialTheme.colorScheme.primaryContainer, MaterialTheme.colorScheme.onPrimary, MaterialTheme.colorScheme.secondaryContainer, MaterialTheme.colorScheme.onSecondaryContainer), onClick = { /* Handle save button click */ }) {
                Text(text = stringResource(R.string.save))
            }
        }
    ) {
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier
            .padding(it)
            .fillMaxWidth()) {
            TextField(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                value = stringResource(R.string.task_title),
                onValueChange = {},

            )
            TextField(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                value = stringResource(R.string.task_description),
                onValueChange = {}
            )
        }
    }
}

@Preview
@Composable
fun TaskDetailPanePreview() {
    PixelPlannerTheme {
        TaskUpsertPane()
    }
}