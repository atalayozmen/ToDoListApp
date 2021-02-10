package com.example.todolistapp;

import java.util.ArrayList;

public class ArrayListHolder {
    public static ArrayList<DoneTask> finishedTasks = new ArrayList<>();

    public static ArrayList<DoneTask> getFinishedTask() {
        return finishedTasks;
    }

    public static void addAllTasks(ArrayList<DoneTask> additionalTasks)
    {
        finishedTasks.addAll(additionalTasks);
    }

    public static void addTask(DoneTask donetask)
    {
        finishedTasks.add(donetask);
    }

    public static void setFinishedTask(ArrayList<DoneTask> finishedTask) {
        ArrayListHolder.finishedTasks = finishedTask;
    }
}