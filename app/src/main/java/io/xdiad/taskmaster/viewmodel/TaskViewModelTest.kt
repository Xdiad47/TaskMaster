package io.xdiad.taskmaster.viewmodel

import io.xdiad.taskmaster.database.TaskDao
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TaskViewModelTest {

    @Mock
    private lateinit var taskDao: TaskDao

    private lateinit var viewModel: TaskViewModel

    @Before
    fun setUp() {
        viewModel = TaskViewModel(taskDao)
    }

    @Test
    fun addTask_callsInsert() = runBlockingTest {
        val task = Task(id = 0, title = "Test Task", description = "Do testing", status = "To Do")
        viewModel.addTask(task)
        verify(taskDao).insert(task)
    }
}
