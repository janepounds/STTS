package com.example.seedtrackingtracing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seedtrackingtracing.dataobjects.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {
    private EditText SignInMail, SignInPass;
    private FirebaseAuth auth;
    private TextView SignInButton, signuptxt, resetPassword;
    private ProgressBar progressBar;
    private ImageView eduorange;



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
        eduorange = (ImageView)findViewById(R.id.eduorange);
        
        eduorange.setAdjustViewBounds(true);
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = SignInMail.getText().toString();
                final String password = SignInPass.getText().toString();
                if (validateLogin(user, password)) {
                    //do login
                    doLogin();
                }
            }

            private boolean validateLogin(String username, String password) {
                if (username == null || username.trim().length() == 0) {
                    Toast.makeText(getBaseContext(), "Username is required", Toast.LENGTH_SHORT).show();
                    return false;
                }
                if (password == null || password.trim().length() == 0) {
                    Toast.makeText(getBaseContext(), "Password is required", Toast.LENGTH_SHORT).show();
                    return false;
                }
                return true;
            }
                private void doLogin() {
                    String username = SignInMail.getText().toString();
                    final String password = SignInPass.getText().toString();
                    UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);

                    UserService loginService =
                            ServiceGenerator.createService(UserService.class, username, password);
                    final  User user = new User(username, password);
                    Call<User> call= loginService.userLogin(user);

                    call.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call <User>  call, Response<User> response) {
                            if (response.isSuccessful()) {
                                //  ResObj resObj = response.body();

                                User resObj = response.body();

                                String token = resObj.getToken();


                                        //login start mainmenu activity
                                        Intent intent = new Intent(SignInActivity.this, MainActivity.class);

                                        startActivity(intent);



                            } else {
                                // Toast.makeText(MainActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                                Toast.makeText(SignInActivity.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(SignInActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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













