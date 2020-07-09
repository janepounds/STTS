
package com.example.seedtrackingtracing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
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
        //hide action bar
        getSupportActionBar().hide();
        //firebase instance
        auth = FirebaseAuth.getInstance();
        signUpMail = (EditText) findViewById(R.id.email);
        signUpPassword = (EditText) findViewById(R.id.password);
        signUpButton = (Button) findViewById(R.id.signupbtn);
        signInText = (TextView) findViewById(R.id.sign_in);
        progressBar = (ProgressBar) findViewById(R.id.signup_progressBar);


        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.user_type,
                android.R.layout.simple_spinner_item);
        //link the adapter to the spinner
        Spinner userChoice = (Spinner) findViewById(R.id.spinner);
        userChoice.setAdapter(adapter);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String email = signUpMail.getText().toString();
                String pass = signUpPassword.getText().toString();

                if (!validate()) {
                    onLoginFailed();
                    signUpButton.setEnabled(true);
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

    public boolean validate() {
        boolean valid = true;

        String username = signUpMail.getText().toString();
        String password = signUpPassword.getText().toString();
        String password1 = confirmPassword.getText().toString();

        if (username.isEmpty()) {
            signUpMail.setError("enter a valid user name");
            valid = false;
        } else {
            signUpMail.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 20) {
            signUpPassword.setError("Password must be between 4 to 20 characters!");
            valid = false;
        } else {
            signUpPassword.setError(null);
        }
        if (!(password.equals(password1))) {
            confirmPassword.setError("Passwords do not match !");
            valid = false;
        }

        return valid;
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "sign up failed", Toast.LENGTH_LONG).show();

        signUpButton.setEnabled(true);
    }


}
