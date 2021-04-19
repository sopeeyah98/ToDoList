package com.example.todolist

import kotlinx.coroutines.flow.Flow

class TaskRepository (private val taskDAO: TaskDAO){ // good way to separate
    // manages queries
    // talks to DAO - pass DAO instead of db
    // Room does not queries on the main thread - requires queries to be run on a separate thread

    // get -> store into a list and make it a public property that can be accessed
    // flow type returned

    // for each of the method in the DAO, need to write something to execute in separate threads

    // getAlphabeticalTask
    val allTasks: Flow<List<Task>> = taskDAO.getAlphabeticalTasks()

    // suspend -> ROOM runs all suspend functions/queries off the main thread
    // so we just call & embed it in a method that we can use later
    suspend fun insert(task: Task){
        taskDAO.insertTask(task)
    }
}