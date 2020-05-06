
package com.example.seedtrackingtracing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class SignUpActivity extends AppCompatActivity {
    EditText signUpMail, signUpPassword, confirmPassword;
    Button signUpButton;
    TextView signInText;
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //firebase instance
        auth = FirebaseAuth.getInstance();
        signUpMail = (EditText) findViewById(R.id.email);
        signUpPassword = (EditText) findViewById(R.id.password);
        confirmPassword = (EditText) findViewById(R.id.rpassword);
        signUpButton = (Button) findViewById(R.id.signupbtn);
        signInText = (TextView) findViewById(R.id.sign_in);
        progressBar = (ProgressBar) findViewById(R.id.signup_progressBar);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String email = signUpMail.getText().toString();
                String pass = signUpPassword.getText().toString();
                String confirmPass = confirmPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Please enter your E-mail address", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(getApplicationContext(), "Please enter your Password", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmPass)) {
                    Toast.makeText(getApplicationContext(), "Please confirm your Password", Toast.LENGTH_LONG).show();
                    return;
                }
                if (pass.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter your Password", Toast.LENGTH_LONG).show();
                    return;
                }
                if (pass.length() < 8) {
                    Toast.makeText(getApplicationContext(), "Password must be more than 8 digit", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!(pass.equals(confirmPass))) {
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    auth.createUserWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(SignUpActivity.this, "ERROR", Toast.LENGTH_LONG).show();
                                    } else {
                                        progressBar.setVisibility(View.GONE);
                                        startActivity(new Intent(SignUpActivity.this, EditProfileActivity.class));
                                        finish();
                                    }
                                }
                            });
                }
            }
        });


        signInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(inent);
            }
        });
    }


}
