package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class FinishedTasksActivity extends AppCompatActivity {

    FinishedTasksRecViewAdapter adapter;
    RecyclerView finishedTasksRecView;
    ArrayList<DoneTask> finishedTasks = new ArrayList<>();
    Button clearButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finished_tasks);


//        Intent intent = getIntent();
//        Bundle resultIntent = intent.getBundleExtra("finishedTaskBundle");
//
//
//        if(resultIntent != null)
//        {
//            ArrayList<DoneTask> additionalTasks = new ArrayList<>();
//            additionalTasks = (ArrayList<DoneTask>) resultIntent.getSerializable("finished task");
//
//            finishedTasks.addAll(additionalTasks);
//
//        }


        clearButton = findViewById(R.id.clearButton);




        FinishedTasksRecViewAdapter adapter = new FinishedTasksRecViewAdapter(this);

        adapter.setFinishedTasks();

        finishedTasksRecView = findViewById(R.id.finishedTasksRecView);



        finishedTasksRecView.setAdapter(adapter);
        finishedTasksRecView.setLayoutManager(new LinearLayoutManager(this));

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.clearFinishedTasks();
            }
        });






    }
}