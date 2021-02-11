package com.example.todolistapp;



import java.io.Serializable;

public class DoneTask implements Serializable {
    String taskName;

    public DoneTask() {

    }


    public DoneTask(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
