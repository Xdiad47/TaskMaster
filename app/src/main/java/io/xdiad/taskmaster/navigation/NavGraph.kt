package io.xdiad.taskmaster.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import io.xdiad.taskmaster.screens.AddEditTaskScreen
import io.xdiad.taskmaster.screens.TaskListScreen
import io.xdiad.taskmaster.viewmodel.TaskViewModel



@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val taskViewModel: TaskViewModel = viewModel()  // Initialize TaskViewModel here

    NavHost(navController, startDestination = "taskList") {
        composable("taskList") {
            TaskListScreen(navController, taskViewModel) // Pass the ViewModel to the TaskListScreen
        }
        composable("addEditTask/new") {  // Separate route for adding a new task
            AddEditTaskScreen(navController, taskViewModel, null)
        }
        composable("addEditTask/{taskId}", arguments = listOf(navArgument("taskId") { type = NavType.IntType })) { backStackEntry ->
            // Extract the taskId from the navigation argument
            val taskId = backStackEntry.arguments?.getInt("taskId") ?: -1  // Default to -1 if null
            if (taskId != -1) {
                // Fetch the task via ViewModel and pass it to the AddEditTaskScreen
//                val task = taskViewModel.getTask(taskId).observeAsState().value
//                AddEditTaskScreen(navController, taskViewModel, task)
                val taskId = backStackEntry.arguments?.getInt("taskId")
                AddEditTaskScreen(navController, taskViewModel, taskId)
            } else {
                // Navigate back to task list if taskId is invalid
                navController.navigate("taskList") {
                    popUpTo("taskList") { inclusive = true }
                }
            }
        }
    }
}

