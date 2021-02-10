package com.example.todolistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FinishedTasksRecViewAdapter extends RecyclerView.Adapter<FinishedTasksRecViewAdapter.ViewHolder> {

    Context context;

    ArrayList<DoneTask> finishedTasks = new ArrayList<>();

    public void setFinishedTasks() {
        this.finishedTasks = ArrayListHolder.finishedTasks;

    }

    public FinishedTasksRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donetask_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.doneTask.setText(ArrayListHolder.getFinishedTask().get(position).getTaskName());
            System.out.println("bind");
    }

    @Override
    public int getItemCount() {
        if(finishedTasks != null)
            return finishedTasks.size();
        else
            return 0;
    }



    public void clearFinishedTasks(){
        ArrayListHolder.finishedTasks.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView doneTask;
        ConstraintLayout parent;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            doneTask = itemView.findViewById(R.id.doneTask);
            parent = itemView.findViewById(R.id.doneTaskParent);
            
        }
    }

}
