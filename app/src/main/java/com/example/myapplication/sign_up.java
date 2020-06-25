package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class sign_up extends AppCompatActivity {
    FirebaseAuth mAuth;
    String type;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final EditText un=findViewById(R.id.user);
        final EditText email=findViewById(R.id.email);
        final EditText pass=findViewById(R.id.pass);
        final EditText cnfpass=findViewById(R.id.cnfpass);
        final EditText phone=findViewById(R.id.phone);

        mAuth=FirebaseAuth.getInstance();

        RadioButton fac = findViewById(R.id.rad_fac);
        RadioButton stu = findViewById(R.id.rad_stud);
        RadioGroup rg = findViewById(R.id.rg);

        final String UserName = un.getText().toString();
        final String Pwd = pass.getText().toString();
        final String cnfPwd = cnfpass.getText().toString();
        final String phoneno = phone.getText().toString();
        final String emailid = email.getText().toString();

        int rgCheckedRadioButtonId = rg.getCheckedRadioButtonId();


        if(rgCheckedRadioButtonId == -1000048)
            type = "Faculty";
        else if(rgCheckedRadioButtonId == -1000156)
            type = "Student";


        Button main = findViewById(R.id.up);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  if (!UserName.equalsIgnoreCase("") && Pwd.length() > 5 && cnfPwd.equals(Pwd)
                       // && emailid.contains("@") && !(phoneno.length() < 10)) {
                Log.d(null,"*************************"+emailid);
                Log.d(null,"*************************"+Pwd);


                mAuth.createUserWithEmailAndPassword(emailid, Pwd)
                            .addOnCompleteListener(sign_up.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser firebaseUser = mAuth.getCurrentUser();
                                        assert firebaseUser != null;
                                        String userid = firebaseUser.getUid();

                                        reference= FirebaseDatabase.getInstance().getReference("Users").child(userid);
                                        Log.d(null,"*************************"+emailid);
                                        Log.d(null,"********************************"+reference);
                                        HashMap<String, String> hashMap = new HashMap<>();
                                        hashMap.put("id", userid);
                                        hashMap.put("username", UserName);
                                        hashMap.put("EmailID", emailid);
                                        hashMap.put("Phone Number", phoneno);
                                        hashMap.put("Password", Pwd);
                                        hashMap.put("User Type", type);
                                        reference.setValue(hashMap)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Intent MainIntent = new Intent(sign_up.this, MainActivity.class);
                                                            MainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            startActivity(MainIntent);
                                                            Toast.makeText(sign_up.this, "You are Successfully Registered and Signed In.",
                                                                    Toast.LENGTH_LONG).show();
                                                            finish();
                                                        }
                                                    }
                                                });
                                    } else {
                                        Toast.makeText(sign_up.this, "Registration failed", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }

        });
    }
}
