package io.xdiad.taskmaster.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task): Long  // Ensure Task is an @Entity

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM tasks WHERE id = :taskId")
    fun getTaskById(taskId: Int): LiveData<Task?>

}


//@Dao
//interface TaskDao {
//    @Query("SELECT * FROM tasks")
//    fun getAllTasks(): Flow<List<Task>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(task: Task): Long
//
//    @Update
//    suspend fun update(task: Task)
//
//    @Delete
//    suspend fun delete(task: Task)
//}
