package com.example.ross.masterdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class YearSemester extends AppCompatActivity {
    private static Button button_fall;
    private static Button button_spring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year_semester);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        OnClickButtonListener();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void OnClickButtonListener(){
        button_fall = (Button)findViewById(R.id.button);
        button_fall.setOnClickListener(
                new View.OnClickListener()  {
                    @Override
                    public void onClick(View v){

                        Intent intent = new Intent("com.example.ross.masterdetail.CourseListActivity");
                        intent.putExtra("fall", "fallCourses");
                        startActivity(intent);
                    }
                }
        );
        button_spring = (Button)findViewById(R.id.button2);
        button_spring.setOnClickListener(
                new View.OnClickListener()  {
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("com.example.ross.masterdetail.CourseListActivity");
                        intent.putExtra("spring", "springCourses");
                        startActivity(intent);
                    }
                }
        );
    }

}
