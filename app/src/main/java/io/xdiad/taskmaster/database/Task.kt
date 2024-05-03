package io.xdiad.taskmaster.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
    val status: String
)

//@Entity(tableName = "tasks")
//data class Task(
//    @PrimaryKey(autoGenerate = true) val id: Int = 0,
//    val title: String,
//    val description: String,
//    val status: String  // Values like "To Do", "In Progress", "Done"
//)