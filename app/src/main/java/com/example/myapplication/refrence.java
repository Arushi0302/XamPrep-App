package com.example.myapplication;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class refrence extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refrence);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView cpg = (TextView) findViewById(R.id.cprog);
        cpg.setMovementMethod(LinkMovementMethod.getInstance());

        TextView ash = (TextView) findViewById(R.id.cbook);
        ash.setMovementMethod(LinkMovementMethod.getInstance());

        TextView eee = (TextView) findViewById(R.id.eeeweb);
        eee.setMovementMethod(LinkMovementMethod.getInstance());

        TextView eeea = (TextView) findViewById(R.id.eeebook);
        eeea.setMovementMethod(LinkMovementMethod.getInstance());

        TextView eca = (TextView) findViewById(R.id.ecb1);
        eca.setMovementMethod(LinkMovementMethod.getInstance());

        TextView ecb = (TextView) findViewById(R.id.ecb2);
        ecb.setMovementMethod(LinkMovementMethod.getInstance());

        TextView epc = (TextView) findViewById(R.id.epb);
        epc.setMovementMethod(LinkMovementMethod.getInstance());

        TextView cal = (TextView) findViewById(R.id.calb);
        cal.setMovementMethod(LinkMovementMethod.getInstance());

        TextView egb = (TextView) findViewById(R.id.engb);
        egb.setMovementMethod(LinkMovementMethod.getInstance());

        TextView erap = (TextView) findViewById(R.id.enggrap);
        erap.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tw = (TextView) findViewById(R.id.twc);
        tw.setMovementMethod(LinkMovementMethod.getInstance());

        TextView es = (TextView) findViewById(R.id.evs);
        es.setMovementMethod(LinkMovementMethod.getInstance());

        TextView cp = (TextView) findViewById(R.id.cpp);
        cp.setMovementMethod(LinkMovementMethod.getInstance());

        TextView cp1 = (TextView) findViewById(R.id.cpp1);
        cp1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView cp2 = (TextView) findViewById(R.id.cpp2);
        cp2.setMovementMethod(LinkMovementMethod.getInstance());

        TextView cp3 = (TextView) findViewById(R.id.cpp3);
        cp3.setMovementMethod(LinkMovementMethod.getInstance());

        TextView dw = (TextView) findViewById(R.id.dldw);
        dw.setMovementMethod(LinkMovementMethod.getInstance());

        TextView dd = (TextView) findViewById(R.id.ddw);
        dd.setMovementMethod(LinkMovementMethod.getInstance());

        TextView dd1 = (TextView) findViewById(R.id.ddw1);
        dd1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView md = (TextView) findViewById(R.id.dm);
        md.setMovementMethod(LinkMovementMethod.getInstance());

        TextView md1 = (TextView) findViewById(R.id.dm1);
        md1.setMovementMethod(LinkMovementMethod.getInstance());


    }

}
