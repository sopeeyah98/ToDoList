package com.example.todolist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

//data class Task (val tas: String) {}

// @Entity -> class represents a SQLite table
@Entity(tableName = "task_table")
class Task(@PrimaryKey @ColumnInfo(name="task") val task:String) // define column information

