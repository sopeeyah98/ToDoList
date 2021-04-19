package com.example.todolist

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class TaskViewModel (private val repository: TaskRepository): ViewModel() {
    val allTasks: LiveData<List<Task>> = repository.allTasks.asLiveData()

    // we want to make sure that the view model is running in its own scope
    // in the viewmodel library, it has its own scope called ViewModelScope
    // launch a new coroutine to run each of the suspend functions in the repository
    // ViewModelScope lets things to run based on life cyclies

    fun insert(task: Task) = viewModelScope.launch {
        repository.insert(task)
    }
}

class TaskViewModelFactory(private val repository: TaskRepository): ViewModelProvider.Factory{
    // override create method to return the TaskViewModel

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)){
            return TaskViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}