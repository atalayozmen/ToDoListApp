package com.example.todolistapp;

public class ToDo {
    String task;
    boolean checked;

    public ToDo(String task) {
        this.task = task;
        this.checked = false;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
