package com.example.seedtrackingtracing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    private EditText SignInMail, SignInPass;
    private FirebaseAuth auth;
    private TextView SignInButton, signuptxt, resetPassword;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();
        SignInMail = (EditText) findViewById(R.id.usernameedt);
        SignInPass = (EditText) findViewById(R.id.passwordedt);
        SignInButton = (TextView) findViewById(R.id.signinbtn);
        signuptxt = (TextView) findViewById(R.id.registertv);
        resetPassword = (TextView) findViewById(R.id.resetPasswordTv);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validate()) {
                    onLoginFailed();
                    SignInButton.setEnabled(true);
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                String email = SignInMail.getText().toString();
                final String password = SignInPass.getText().toString();

                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    progressBar.setVisibility(View.GONE);

                                    Toast.makeText(getApplicationContext(), "Error, please check your username and password", Toast.LENGTH_SHORT).show();

                                } else {
                                    Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    progressBar.setVisibility(View.GONE);
                                    finish();
                                }
                            }
                        });
            }
        });

        signuptxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inent = new Intent(SignInActivity.this, ResetPasswordActivity.class);
                startActivity(inent);
            }
        });
    }

    public boolean validate() {
        boolean valid = true;

        String username = SignInMail.getText().toString();
        String password = SignInPass.getText().toString();

        if (username.isEmpty()) {
            SignInMail.setError("enter a valid user name");
            valid = false;
        } else {
            SignInMail.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 20) {
            SignInPass.setError("Please enter a valid password!");
            valid = false;
        } else {
            SignInPass.setError(null);
        }

        return valid;
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        SignInButton.setEnabled(true);
    }
}
