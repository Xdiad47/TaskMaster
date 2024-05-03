package io.xdiad.taskmaster.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import io.xdiad.taskmaster.database.Task
import io.xdiad.taskmaster.viewmodel.TaskViewModel

@Composable
fun AddEditTaskScreen(navController: NavHostController, taskViewModel: TaskViewModel, taskId: Int? = null) {
    // Observe the task LiveData and react to changes
    val task by taskViewModel.getTask(taskId).observeAsState()

    // State for the text fields
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("To Do") }

    // Update state when task data is loaded or changes
    LaunchedEffect(task) {
        title = task?.title ?: ""
        description = task?.description ?: ""
        status = task?.status ?: "To Do"
    }

    val statusOptions = listOf("To Do", "In Progress", "Done")
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") }
        )
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") }
        )
        Button(onClick = { expanded = true }) {
            Text(text = status)
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "Dropdown")
        }

        Box {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
               // modifier = Modifier.offset(y = 48.dp) // Adjust the offset as needed
            ) {
                statusOptions.forEach { option ->
                    DropdownMenuItem(
                        onClick = {
                            status = option
                            expanded = false
                        },
                        text = { Text(option) }  // Correct usage of the text lambda
                    )
                }
            }
        }

//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false }
//        ) {
//            statusOptions.forEach { option ->
//                DropdownMenuItem(
//                    onClick = {
//                        status = option
//                        expanded = false
//                    },
//                    text = { Text(option) }  // Correct usage of the text lambda
//                )
//            }
//        }
        Button(onClick = {
            if (task == null) {
                taskViewModel.addTask(Task(title = title, description = description, status = status))
            } else {
                taskViewModel.updateTask(task!!.copy(title = title, description = description, status = status))
            }
            navController.popBackStack()
        }) {
            Text("Save")
        }
    }
}



//@Composable
//fun AddEditTaskScreen(navController: NavHostController, taskViewModel: TaskViewModel, task: Task? = null) {
//
//    var title by rememberSaveable { mutableStateOf(task?.title ?: "") }
//    var description by rememberSaveable { mutableStateOf(task?.description ?: "") }
//    var status by rememberSaveable { mutableStateOf(task?.status ?: "To Do") }
//    val statusOptions = listOf("To Do", "In Progress", "Done")
//    var expanded by remember { mutableStateOf(false) }
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        TextField(value = title, onValueChange = { title = it }, label = { Text("Title") })
//        TextField(value = description, onValueChange = { description = it }, label = { Text("Description") })
//
//        // Button to trigger the dropdown menu
//        Button(onClick = { expanded = true }) {
//            Text(text = status)  // Display current status
//            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "Dropdown")
//        }
//
//        // Dropdown menu for selecting status
//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false }
//        ) {
//            statusOptions.forEach { option ->
//                DropdownMenuItem(
//                    onClick = {
//                        status = option
//                        expanded = false
//                    },
//                    text = { Text(option) }  // Correct usage of the text lambda
//                )
//            }
//        }
//
//        // Save button
//        Button(onClick = {
//            if (task == null) {
//                // Create a new task if no task is being edited
//                taskViewModel.addTask(Task(title = title, description = description, status = status))
//            } else {
//                // Update existing task
//                taskViewModel.updateTask(task.copy(title = title, description = description, status = status))
//            }
//            navController.popBackStack()  // Return to the previous screen after saving
//        }) {
//            Text("Save")
//        }
//    }
//}

