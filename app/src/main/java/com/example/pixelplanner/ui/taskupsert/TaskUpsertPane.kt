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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pixelplanner.R
import com.example.pixelplanner.ui.AppViewModelProvider
import com.example.pixelplanner.ui.theme.PixelPlannerTheme

@Composable
fun TaskUpsertPane(
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: TaskUpsertViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val task = viewModel.task.collectAsState()

    Scaffold(
                floatingActionButton = {
            Button(colors = ButtonColors(MaterialTheme.colorScheme.primaryContainer, MaterialTheme.colorScheme.onPrimary, MaterialTheme.colorScheme.secondaryContainer, MaterialTheme.colorScheme.onSecondaryContainer), onClick = { onSaveClick() }) {
                Text(text = stringResource(R.string.save))
            }
        }
    ) { it ->
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()) {
            TextField(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                value = task.value.task.title,
                onValueChange = { viewModel.upsertTaskTitle(it) },

            )
            TextField(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                value = task.value.task.description,
                onValueChange = { viewModel.upsertTaskDescription(it) }
            )
        }
    }
}

@Preview
@Composable
fun TaskDetailPanePreview() {
    PixelPlannerTheme {
        TaskUpsertPane( onSaveClick = {} )
    }
}