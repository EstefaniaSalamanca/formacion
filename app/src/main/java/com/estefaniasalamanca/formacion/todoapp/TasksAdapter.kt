package com.estefaniasalamanca.formacion.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.estefaniasalamanca.formacion.R


class TasksAdapter (var tasks:List<Task>, private val onTasKSelected: (Int) -> Unit):
    RecyclerView.Adapter<TasksViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task,parent,false)
        return TasksViewHolder(view)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.render(tasks[position])
        holder.itemView.setOnClickListener{onTasKSelected(position)}

    }

    override fun getItemCount() = tasks.size
}


