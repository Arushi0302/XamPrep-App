package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class motivation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView mot = (TextView) findViewById(R.id.add_succ);
                mot.setMovementMethod(LinkMovementMethod.getInstance());

        TextView mot1 = (TextView) findViewById(R.id.jam_clr);
        mot1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView mot2 = (TextView) findViewById(R.id.tin_bud);
        mot2.setMovementMethod(LinkMovementMethod.getInstance());

        TextView mot3 = (TextView) findViewById(R.id.dee_exit);
        mot3.setMovementMethod(LinkMovementMethod.getInstance());

        TextView mot4 = (TextView) findViewById(R.id.mot_gri);
        mot4.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
