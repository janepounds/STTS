package com.example.seedtrackingtracing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
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



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {
    private EditText SignInMail, SignInPass;
    private FirebaseAuth auth;
    private TextView SignInButton, signuptxt, resetPassword;
    private ProgressBar progressBar;
    private ImageView eduorange;
    private static final String DIALOG_TITLE = "Please wait ..." ;
    private static final String DIALOG_MESSAGE = "Authenticating.." ;
    final Handler mHandler = new Handler();
    private Toast backtoast;

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
        progressBar.setVisibility(View.INVISIBLE);

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
                showprogessDialog();
                String username = SignInMail.getText().toString();
                final String password = SignInPass.getText().toString();
                String action = "login";
//                UserService service = RetrofitClient.getRetrofitInstance().ge
//
//                UserService loginService =
//                        ServiceGenerator.createService(UserService.class,username, password);
                final User user = new User(action,username,password);

                Call<User> call= RetrofitClient.getRetrofitInstance().create(UserService.class).userLogin(user);

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call <User>  call, Response<User> response) {
                        if (response.isSuccessful()) {
                            //  ResObj resObj = response.body();

                            User resObj = response.body();
                            String output = response.body().toString();

                            String token = resObj.getToken();
//                            String user_info [] = resObj.getUser_info();
//                            String name = user_info[1];cons


                            Toast.makeText(SignInActivity.this, output, Toast.LENGTH_SHORT).show();
                            //login start mainmenu activity
                            Intent intent = new Intent(SignInActivity.this, MainActivity.class);

                            startActivity(intent);



                        } else {
                            // Toast.makeText(MainActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
//                                Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(SignInActivity.this, response.message(), Toast.LENGTH_SHORT).show();
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
                v.getContext().startActivity(intent);
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




public void showprogessDialog(){

    final ProgressDialog dialog = new ProgressDialog(this);
    dialog.setTitle(DIALOG_TITLE);
    dialog.setMessage(DIALOG_MESSAGE);
    dialog.setIndeterminate(true);
    dialog.setCancelable(true);
    dialog.show();

    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(5 * 1000); // Here we can place our time consuming task
                dismissDialog(dialog);
            }catch(Exception e){
                dismissDialog(dialog);
            }

        }
    }).start();


    }

    public void dismissDialog(final ProgressDialog pd){
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                pd.dismiss();
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

    private boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

}













