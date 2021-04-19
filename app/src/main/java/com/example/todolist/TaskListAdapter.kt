package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class TaskListAdapter: ListAdapter<Task, TaskListAdapter.TaskViewHolder>(TaskComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentTask = getItem(position)
        holder.bindText(currentTask.task, holder.taskTextView)
    }

    class TaskViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val taskTextView: TextView = itemView.findViewById(R.id.textView)

        // write a helper function that takes a string & a textview
        // assign text to the textview
        fun bindText(text:String?, textView: TextView){
            textView.text = text
        }

        companion object{
            fun create(parent: ViewGroup): TaskViewHolder{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
                return TaskViewHolder(view)
            }
        }
    }

    class TaskComparator: DiffUtil.ItemCallback<Task>(){
        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.task == newItem.task // compare primary keys
            // make task as comparable or compare all elements
        }

        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem === newItem
        }
    }
}