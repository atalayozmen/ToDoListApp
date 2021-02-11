package com.example.todolistapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String TODOLIST_TABLE = "TODOLIST_TABLE";
    public static final String TODOLIST_FINISHED_TABLE = "TODOLIST_FINISHED_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_TASK = "TASK";


    public DataBaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createToDoListTable = "CREATE TABLE IF NOT EXISTS " + TODOLIST_TABLE +" (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TASK + " TEXT)";
        String createToDoListFinishedTable = "CREATE TABLE IF NOT EXISTS " + TODOLIST_FINISHED_TABLE +" (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TASK + " TEXT)";


        db.execSQL(createToDoListTable);
        db.execSQL(createToDoListFinishedTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addTaskToToDoList(ToDo newTask) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TASK,newTask.getTask() );

        long insert = db.insert(TODOLIST_TABLE, null, cv);

        if(insert == -1)
            return false;
        else
            return true;

    }

    public boolean deleteTaskFromToDoList(ToDo taskToBeDeleted) {
        SQLiteDatabase db = getWritableDatabase();
        int delete = db.delete(TODOLIST_TABLE, COLUMN_TASK + "='" + taskToBeDeleted.getTask() + "'", null);

        if(delete == -1)
            return false;
        else
            return true;
    }

    public boolean addFinishedTaskToFinishedTaskTable(DoneTask doneTask) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TASK,doneTask.getTaskName());
        long insert = db.insert(TODOLIST_FINISHED_TABLE, null, cv);

        db.close();

        if(insert == -1)
            return false;
        else
            return true;


    }

//    public boolean addMultipleTasksToFinishedTasksTable(DoneTask doneTask) {
//        SQLiteDatabase db = getWritableDatabase();
//
//        ContentValues cv = new ContentValues();
//        cv.put(COLUMN_TASK,doneTask.getTaskName());
//        long insert = db.insert(TODOLIST_FINISHED_TABLE, null, cv);
//
//        db.close();
//
//        if(insert == -1)
//            return false;
//        else
//            return true;
//
//
//    }

    public boolean deleteAllFinishedTasksFromDB() {
        SQLiteDatabase db = getWritableDatabase();
        String deleteQuery = "DELETE FROM " + TODOLIST_FINISHED_TABLE;
        Cursor cursor = db.rawQuery(deleteQuery, null);

        if(cursor.moveToFirst())
            return true;
        else
            return false;

    }


    public List<ToDo> getAllTasksToDoFromDB() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TODOLIST_TABLE;
        List<ToDo> allToDoTasks = new ArrayList<>();

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            do{
                ToDo task = new ToDo();
                task.setTask(cursor.getString(1));
                allToDoTasks.add(task);

            }
            while(cursor.moveToNext());


        }

        cursor.close();
        db.close();
        return allToDoTasks;
    }



    public List<DoneTask> getAllFinishedTasksFromDB() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TODOLIST_FINISHED_TABLE;
        List<DoneTask> allFinishedTasks = new ArrayList<>();

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            do{
                DoneTask task = new DoneTask();
                task.setTaskName(cursor.getString(1));
                allFinishedTasks.add(task);

            }
            while(cursor.moveToNext());


        }

        cursor.close();
        db.close();
        return allFinishedTasks;
    }




}
