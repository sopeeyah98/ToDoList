package com.example.todolist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Task::class), version = 1, exportSchema = false) // no data migration
public abstract class TaskRoomDatabase: RoomDatabase(){ // must be abstract & should extend room database class
    // need just one db
    // each entity corresponds to a db table created - in this case, just one

    // connects with DAO
    abstract fun taskDAO(): TaskDAO // getter

    companion object{
        // singleton - useful when one object is needed to coordinate design system
        @Volatile
        private var INSTANCE:TaskRoomDatabase? = null

        fun getDatabase(context: Context): TaskRoomDatabase{
            // if instance is not null, then return
            // if null, create the db
            return INSTANCE ?: synchronized(this){
                // create the database
                // return the database
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskRoomDatabase::class.java,
                    "task_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}