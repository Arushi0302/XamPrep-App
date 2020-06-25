package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class front extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button main=findViewById(R.id.btn_paper);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Year.class);
                startActivity(intent);
            }
        });
        Button fun=findViewById(R.id.btn_motivation);
        fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), motivation.class);
                startActivity(intent);
            }
        });
        Button cal=findViewById(R.id.btn_calculator);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), gpa.class);
                startActivity(intent);
            }
        });
        Button mat=findViewById(R.id.btn_material);
        mat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), refrence.class);
                startActivity(intent);
            }
        });
        Button scd=findViewById(R.id.btn_sched);
        scd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SchedulerActivity.class);
                startActivity(intent);
            }
        });
    }

}
