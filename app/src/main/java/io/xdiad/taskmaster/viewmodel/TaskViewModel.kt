package io.xdiad.taskmaster.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import io.xdiad.taskmaster.AppDatabase
import io.xdiad.taskmaster.database.Task
import kotlinx.coroutines.launch


class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val database = AppDatabase.getDatabase(application)
    private val taskDao = database.taskDao()

    val tasks: LiveData<List<Task>> = taskDao.getAllTasks().asLiveData()

    fun addTask(task: Task) = viewModelScope.launch {
        taskDao.insert(task)
    }

    fun updateTask(task: Task) = viewModelScope.launch {
        taskDao.update(task)
    }

    fun deleteTask(task: Task) = viewModelScope.launch {
        taskDao.delete(task)
    }

    // Method to get a task by its ID
//    fun getTask(taskId: Int): LiveData<Task?> {
//        return taskDao.getTaskById(taskId)
//    }

    fun getTask(taskId: Int?): LiveData<Task?> {
        return taskId?.let {
            taskDao.getTaskById(it)
        } ?: liveData { emit(null) }
    }

}



