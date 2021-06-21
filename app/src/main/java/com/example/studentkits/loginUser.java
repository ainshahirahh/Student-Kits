package com.example.studentkits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.InputType;
import android.widget.LinearLayout;
import com.google.android.gms.tasks.Task;

public class loginUser extends AppCompatActivity {

    private EditText editEmailLogin;
    private EditText editPasswordLogin;
    private Button buttonLogin;
    private TextView newRegister;
    private TextView forgetpass;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        firebaseAuth = FirebaseAuth.getInstance();

        editEmailLogin = findViewById(R.id.editEmailLogin);
        editPasswordLogin = findViewById(R.id.editPasswordLogin);
        buttonLogin = findViewById(R.id.buttonLogin);
        newRegister = findViewById(R.id.newRegister);
        newRegister.setMovementMethod(LinkMovementMethod.getInstance());

        newRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(loginUser.this, registerUser.class);
                startActivity(intentLoadNewActivity);
            }
        });

        forgetpass = findViewById(R.id.forgetpass);
        // click on forget password text
        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRecoverPasswordDialog();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getEmail = editEmailLogin.getText().toString().trim();
                String getPassword = editPasswordLogin.getText().toString().trim();

                if (TextUtils.isEmpty(getEmail)) {
                    editEmailLogin.setError("Email is required!");
                    return;
                }

                if (TextUtils.isEmpty(getPassword)) {
                    editPasswordLogin.setError("Password is required!");
                    return;
                }


                firebaseAuth.signInWithEmailAndPassword(getEmail, getPassword)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(loginUser.this, "Welcome to Student Kits!", Toast.LENGTH_SHORT).show();
                                Intent intentLoadNewActivity = new Intent(loginUser.this, MainActivity.class);
                                startActivity(intentLoadNewActivity);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(loginUser.this, "The password is invalid or the user does not exist", Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        });

    }

    private void showRecoverPasswordDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Recover Your Student Kits Account:");
        LinearLayout linearLayout = new LinearLayout(this);
        final EditText emailet = new EditText(this);

        //user key in email that have been registered
        emailet.setHint("Enter your email here");
        emailet.setMinEms(16);
        emailet.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        linearLayout.addView(emailet);
        linearLayout.setPadding(10, 10, 10, 10);
        builder.setView(linearLayout);

        // Click on Recover and a email will be sent to your registered email id
        builder.setPositiveButton("Recover", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String emaill = emailet.getText().toString().trim();
                beginRecovery(emaill);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void beginRecovery(String emaill) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sending Email....");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        // calling sendPasswordResetEmail
        // open your email and write the new
        // password and then you can login
        firebaseAuth.sendPasswordResetEmail(emaill).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()) { //if successful, user can check reset the password
                    Toast.makeText(loginUser.this, "Recovery link has been sent! Check email.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(loginUser.this, "Email is invalid!", Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(loginUser.this, "Error Failed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
