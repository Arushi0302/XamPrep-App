package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);

        mAuth=FirebaseAuth.getInstance();

        TextView signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), sign_up.class);
                startActivity(intent);
            }
        });
        TextView reset = findViewById(R.id.forgot_password);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), forget_password.class);
                startActivity(intent);
            }
        });


        Button main = findViewById(R.id.login);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String UserName = username.getText().toString();
                String Pwd = password.getText().toString();

                mAuth.signInWithEmailAndPassword(UserName, Pwd)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent MainIntent = new Intent(MainActivity.this, front.class);
                                    MainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(MainIntent);
                                    Toast.makeText(MainActivity.this, "You are Successfully Signed In.",
                                            Toast.LENGTH_LONG).show();
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivity.this, "Authentication failed.",
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
    }
}
