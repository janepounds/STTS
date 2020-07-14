
package com.example.seedtrackingtracing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
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
    TextView signUpButton;
    TextView signInText;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private static final String DIALOG_TITLE = "Please wait ..." ;
    private static final String DIALOG_MESSAGE = "Creating account.." ;
    final Handler mHandler = new Handler();

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
        signUpButton = (TextView) findViewById(R.id.signupbtn);
        signInText = (TextView) findViewById(R.id.sign_in);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);


        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.user_type,
                android.R.layout.simple_spinner_item);
        //link the adapter to the spinner
        Spinner userChoice = (Spinner) findViewById(R.id.spinner);
        userChoice.setAdapter(adapter);
        userChoice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long Id) {
                if (i == 0) { // When user clicked on "Choose One" hint and the initial call.
                    ((TextView) view).setTextColor(getResources().getColor(R.color.hint_color));
                    ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                    return;
                }
                i--;  // undo the "Choose One" hint.

                // Your business logic

                // i = 0 map to item0
                // i = 1 map to item1
                // ...

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showprogessDialog();
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

}
