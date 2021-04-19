package com.example.todolist

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDAO {
    // what sql queries do we need?
    // get entries & sort by alphabetical order
    // insert a task into the database

    // DAO class should always be either interface or abstract class

    @Query("SELECT * FROM task_table ORDER BY task ASC")
    fun getAlphabeticalTasks(): Flow<List<Task>> // any function that returns use flow

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: Task) // allows concurrent actions
}