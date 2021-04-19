package com.example.todolist

import android.app.Application

class TaskApplication: Application() {
    // create 1 instance of db
    // create 1 instance of repository

    // lazy - property: value gets computed/ expression gets executed only upon first access
    // not created when app starts but only when needed

    val database by lazy {
        TaskRoomDatabase.getDatabase(this)
    }
    val repository by lazy {
        TaskRepository(database.taskDAO())
    }
}