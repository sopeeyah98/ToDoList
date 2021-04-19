package com.example.todolist

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class AddActivity: AppCompatActivity() {

    private lateinit var editTextTask: EditText
    private lateinit var buttonSave: Button
    private val taskViewModel: TaskViewModel by viewModels{
        TaskViewModelFactory((application as TaskApplication).repository)
    } // call the one and only repository created in the application class
    // to prevent from creating multiple instances of the repository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        editTextTask = findViewById(R.id.edit_word)
        buttonSave = findViewById(R.id.button_save)

        // catch user error in the front end
        buttonSave.setOnClickListener {
            if (TextUtils.isEmpty(editTextTask.text)){
                toastError("missing fields")
            } else {
                // grab the text, make it into a task type
                // call the insert function to insert into db
                val task = Task(editTextTask.text.toString())
                taskViewModel.insert(task)
                finish()
            }
        }
    }

    private fun toastError(text:String){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}