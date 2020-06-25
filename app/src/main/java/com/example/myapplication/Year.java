package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Year extends AppCompatActivity {

    Button submit;
    RadioButton r1, r2, r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Spinner spinner1 = (Spinner) findViewById(R.id.planets_spinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        Spinner spinner2 = (Spinner) findViewById(R.id.sem_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.sem_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        submit = findViewById(R.id.btn_sub);
        r1 = findViewById(R.id.rad_tee);
        r2 = findViewById(R.id.rad_cat1);
        r3 = findViewById(R.id.rad_cat2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r1.isChecked()) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://drive.google.com/drive/folders/1LeiH87ASyijC9HV0vJrh-MxtmhEMO_cS?usp=sharing"));
                    startActivity(intent);
                } else if (r2.isChecked()) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://drive.google.com/drive/folders/1Gskcm9spY_XVYYn4WbcSsiQVbEIiwFCZ?usp=sharing"));
                    startActivity(intent);
                } else {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://drive.google.com/drive/folders/1sQilg_IMKF9I6q_tG4FuKDQw_Vk2gJ80?usp=sharing"));
                    startActivity(intent);
                }
            }
        });

    }

}
