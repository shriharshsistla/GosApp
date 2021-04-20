package com.example.gosapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    FirebaseAuth auth;
    EditText emailbox,passwordBox,nameBox;
    Button loginBtn,signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        auth = FirebaseAuth.getInstance();


        emailbox = findViewById(R.id.emailBox);
        nameBox = findViewById(R.id.editTextTextPersonName);
        passwordBox = findViewById(R.id.passBox);

        loginBtn = findViewById(R.id.loginbtn);
        signupButton = findViewById(R.id.createbtn);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password,name;
                email = emailbox.getText().toString();
                password = passwordBox.getText().toString();
                name = nameBox.getText().toString();

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignupActivity.this,"Account Created Successfully",Toast.LENGTH_SHORT).show();


                        }else{
                            Toast.makeText(SignupActivity.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });


            }
        });
    }
}