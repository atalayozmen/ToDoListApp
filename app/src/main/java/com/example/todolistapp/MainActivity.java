package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TodolistRecViewAdapter adapter;

    private ConstraintLayout parent;
    private Button addBtn;
    private EditText editText;
    private String toDoTask;
    private Button deleteBtn, seeFinishedTasksBtn;

    private RecyclerView todolistRecView;
    ArrayList<DoneTask> finishedTasks = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editText = findViewById(R.id.editText);
        addBtn = findViewById(R.id.addBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        seeFinishedTasksBtn = findViewById(R.id.seeFinishedTasksBtn);


        todolistRecView = findViewById(R.id.todolistRecView);


        ArrayList<ToDo> tasks = new ArrayList<>();


        ToDo taskToDo = new ToDo("Atalay");

        tasks.add(taskToDo);

        adapter = new TodolistRecViewAdapter(this);



        adapter.setTasks(tasks);

        todolistRecView.setAdapter(adapter);
        todolistRecView.setLayoutManager(new LinearLayoutManager(this));


        seeFinishedTasksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FinishedTasksActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("finished task",(Serializable) finishedTasks);
                intent.putExtra("finishedTaskBundle", args);
                startActivity(intent);
                finishedTasks.clear();




            }
        });


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDo newtask = new ToDo(editText.getText().toString());
                adapter.addTask(newtask);
                editText.setText("");
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayListHolder.addAllTasks(adapter.deleteTasks());
                adapter.resetFinishedTasks();
            }
        });

    }


}