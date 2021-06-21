package com.example.studentkits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registerUser extends AppCompatActivity {

    private EditText editEmailAddress;
    private EditText editPassword;
    private Button buttonRegister;
    private TextView newLogin;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        editEmailAddress = findViewById(R.id.editEmailAddress);
        editPassword = findViewById(R.id.editPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        newLogin = findViewById(R.id.newLogin);
        newLogin.setMovementMethod(LinkMovementMethod.getInstance());

        newLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(registerUser.this, loginUser.class);
                startActivity(intentLoadNewActivity);
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getEmail = editEmailAddress.getText().toString().trim();
                String getPassword = editPassword.getText().toString().trim();

                if (TextUtils.isEmpty(getEmail)) {
                    editEmailAddress.setError("Email is required!");
                    return;
                }

                if (TextUtils.isEmpty(getPassword)) {
                    editPassword.setError("Password is required!");
                    return;
                }


                firebaseAuth.createUserWithEmailAndPassword(getEmail, getPassword)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(registerUser.this, "User Account Successfully Created!", Toast.LENGTH_SHORT).show();
                                Intent intentLoadNewActivity = new Intent(registerUser.this, loginUser.class);
                                startActivity(intentLoadNewActivity);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(registerUser.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}
