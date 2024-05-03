package io.xdiad.taskmaster.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import io.xdiad.taskmaster.database.Task
import io.xdiad.taskmaster.viewmodel.TaskViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme


// Now write test cases and Unit test cases and then submit it to github

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskListScreen(navController: NavHostController, viewModel: TaskViewModel = viewModel()) {
    val tasks = viewModel.tasks.observeAsState(initial = emptyList())
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("addEditTask/new") }) {
                Icon(Icons.Filled.Add, contentDescription = "Add Task")
            }
        }
    ) {
        LazyColumn {
            items(tasks.value) { task ->
                TaskItem(
                    task = task,
                    onEditClick = { navController.navigate("addEditTask/${task.id}") }, // Assuming task ID navigation is handled
                    onDeleteClick = { viewModel.deleteTask(task) }
                )
            }
        }
    }
}


@Composable
fun TaskItem(task: Task, onEditClick: () -> Unit, onDeleteClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = task.title,
                style = MaterialTheme.typography.titleMedium,  // Use larger typography for the title
                color = MaterialTheme.colorScheme.onSurface
            )
            if (task.description.isNotEmpty()) {  // Check if the description is not empty
                Text(
                    text = task.description,
                    style = MaterialTheme.typography.titleSmall,  // Use smaller typography for the description
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = task.status,
                    style = MaterialTheme.typography.titleSmall,  // Use smaller typography for the description
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = onEditClick) {
                    Icon(Icons.Filled.Edit, contentDescription = "Edit")
                }
                IconButton(onClick = onDeleteClick) {
                    Icon(Icons.Filled.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}



/*
@Composable
fun TaskItem(task: Task, onEditClick: () -> Unit, onDeleteClick: () -> Unit) {
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = task.title)
            IconButton(onClick = onEditClick) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit")
            }
            IconButton(onClick = onDeleteClick) {
                Icon(Icons.Filled.Delete, contentDescription = "Delete")
            }
        }
    }
}*/












/*
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskListScreen(navController: NavHostController, viewModel: TaskViewModel = viewModel()) {
    val tasks = viewModel.tasks.observeAsState(initial = emptyList())
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("addEditTask") }) {
                Icon(Icons.Filled.Add, contentDescription = "Add Task")
            }
        }
    ) {
        LazyColumn {
            items(tasks.value) { task ->
                TaskItem(task, onEditClick = { /* handle edit */ }, onDeleteClick = { /* handle delete */ })
            }
        }
    }
}
*/

/*
@Composable
fun TaskListScreen(navController: NavHostController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("addEditTask") }) {
                Icon(Icons.Filled.Add, contentDescription = "Add Task")
            }
        }
    ) {
        LazyColumn {
            items(tasks) { task ->
                TaskItem(task, onEditClick = { /* handle edit */ }, onDeleteClick = { /* handle delete */ })
            }
        }
    }
}
*/

/*
@Composable
fun TaskItem(task: Task, onEditClick: () -> Unit, onDeleteClick: () -> Unit) {
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = task.title)
            IconButton(onClick = onEditClick) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit")
            }
            IconButton(onClick = onDeleteClick) {
                Icon(Icons.Filled.Delete, contentDescription = "Delete")
            }
        }
    }
}
*/