package com.example.todolistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodolistRecViewAdapter extends RecyclerView.Adapter<TodolistRecViewAdapter.ViewHolder> {

    ArrayList<ToDo> tasks = new ArrayList<>();
    Context context;
    ArrayList<DoneTask> finishedTasks = new ArrayList<>();

    public TodolistRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todolist_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.taskToDo.setText(tasks.get(position).getTask());
        holder.checkbox.setOnCheckedChangeListener(null);
        holder.checkbox.setChecked(tasks.get(position).isChecked());

        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tasks.get(position).setChecked(!tasks.get(position).isChecked());


            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void setTasks(ArrayList<ToDo> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    public void addTask(ToDo task) {
        tasks.add(task);

        notifyDataSetChanged();
    }

    public void resetFinishedTasks() {
        finishedTasks.clear();
    }


    public ArrayList<DoneTask> deleteTasks() {


        for(int i=tasks.size() -1; i>=0; --i) {
            if(tasks.get(i).isChecked())
            {
                DoneTask newFinishedTask = new DoneTask(tasks.get(i).getTask());
                finishedTasks.add(newFinishedTask);
                tasks.remove(i);
                notifyDataSetChanged();
            }
        }

        return finishedTasks;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView taskToDo;
        private CheckBox checkbox;
        private ConstraintLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            taskToDo = itemView.findViewById(R.id.taskToBeDoneTxt);
            parent = itemView.findViewById(R.id.parent);
            checkbox = itemView.findViewById(R.id.checkbox);

        }
    }

}
